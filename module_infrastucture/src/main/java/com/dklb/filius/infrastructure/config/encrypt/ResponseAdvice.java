package com.dklb.filius.infrastructure.config.encrypt;

import com.dklb.filius.infrastructure.helpers.models.general.Resultado;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.modelmapper.ModelMapper;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice {

    ModelMapper modelMapper=new ModelMapper();
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        Resultado resultado =modelMapper.map(body,Resultado.class);

        String jsonRespuesta=converObjectToStringJson(resultado.respuesta);

        resultado.mensaje=CipherX.encrypt(resultado.mensaje);
        resultado.respuesta=CipherX.encrypt(jsonRespuesta);

        return resultado;
    }

    public static String converObjectToStringJson(Object object)  {
        ObjectWriter ow = new ObjectMapper().writer();
        String json=null;
        try {
            json = ow.writeValueAsString(object);
        }catch (JsonProcessingException e) {
            System.out.println(e.toString());
        }
        return json;
    }
}
