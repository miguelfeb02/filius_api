package com.dklb.filius.infrastructure.config.encrypt;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import com.dklb.filius.infrastructure.helpers.models.general.GeneralRequest;
import com.dklb.filius.infrastructure.helpers.models.general.HttpInputMessageModel;
import com.google.gson.Gson;
import jakarta.annotation.Nonnull;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;


@RestControllerAdvice
public class RequestAdvice extends RequestBodyAdviceAdapter {


    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return false;
    }

    @Override
    @Nonnull
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        try (InputStream inputStream = inputMessage.getBody()) {
            byte[] body = StreamUtils.copyToByteArray(inputStream);
            Gson g = new Gson();
            GeneralRequest generalRequest = g.fromJson(new String(body), GeneralRequest.class);
            String decrypt=decrypt(generalRequest.getBody());
            generalRequest.setBody(decrypt);
            byte[] byteArrray = generalRequest.generateStringJson().getBytes(StandardCharsets.UTF_8);
            InputStream inputStreamOut = new ByteArrayInputStream(byteArrray);

            return new HttpInputMessageModel(inputMessage.getHeaders(), inputStreamOut);
        }
    }

    public static String decrypt(Object object) {
        byte[] decode = Base64.getDecoder().decode(object.toString());
        return new String(decode);
    }
}
