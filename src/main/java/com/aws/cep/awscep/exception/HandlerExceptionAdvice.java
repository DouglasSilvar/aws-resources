package com.aws.cep.awscep.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerExceptionAdvice {

    @ExceptionHandler(NotFoundCepException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String notFoundCepExceptionHandler(NotFoundCepException e) {
        return e.getMessage();
    }
}
