package com.dklb.filius.infrastructure.config.security.encrypt;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

import jakarta.annotation.Nonnull;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.RequestBodyAdviceAdapter;


import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class DecryptRequest extends RequestBodyAdviceAdapter {


    @Override
    public boolean supports(MethodParameter methodParameter, Type targetType, Class<? extends HttpMessageConverter<?>> converterType) {
        return methodParameter.hasParameterAnnotation(EncriptFilter.class);
    }

    @Override
    @Nonnull
    public HttpInputMessage beforeBodyRead(HttpInputMessage inputMessage, MethodParameter parameter, Type targetType,
                                           Class<? extends HttpMessageConverter<?>> converterType) throws IOException {

        try (InputStream inputStream = inputMessage.getBody()) {
            byte[] body = StreamUtils.copyToByteArray(inputStream);
            log.info("raw: {}", new String(body));
            return new DecryptHttpInputMessage(inputMessage.getHeaders(), new ByteArrayInputStream(body));
        }
    }
}
