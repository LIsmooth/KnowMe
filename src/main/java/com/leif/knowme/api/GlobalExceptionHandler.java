package com.leif.knowme.api;

import com.leif.knowme.exception.AuthException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    //其他未处理的异常
    @ExceptionHandler(AuthException.class)
    @ResponseBody
    public Object authExceptionHandler(AuthException e){
        return new KmResponse(KmResponse.KM_RESPONSE_CODE_ERR_AUTH_EXPIRED,"授权验证错误");
    }

    //其他未处理的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object exceptionHandler(Exception e){
        logger.error("Exception:",e);
        return new KmResponse(KmResponse.KM_RESPONSE_CODE_ERR_SYSTEM,"系统错误");

    }
}
