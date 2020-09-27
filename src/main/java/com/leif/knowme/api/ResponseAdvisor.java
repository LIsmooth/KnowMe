package com.leif.knowme.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.leif.knowme.base.KmResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ResponseAdvisor implements ResponseBodyAdvice<Object> {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType,
                                  Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request,
                                  ServerHttpResponse response) {
        if (body instanceof KmResponse) {
            return body;
        }
        KmResponse kmResponse = new KmResponse(body);
        if (body instanceof String) {
            try {
                return convertToJsonString(kmResponse);
            } catch (JsonProcessingException e) {
                logger.error("convertToJsonString error\n", e);
                return KmResponse.buildErrorResponse(KmResponse.KM_RESPONSE_CODE_TRANSFER, e.getMessage());
            }
        }
        return kmResponse;
    }

    private String convertToJsonString(KmResponse kmResponse) throws JsonProcessingException {
        ObjectMapper obj = new ObjectMapper();
        return obj.writeValueAsString(kmResponse);
    }
}