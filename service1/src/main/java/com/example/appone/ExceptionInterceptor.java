package com.example.appone;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;

@ControllerAdvice
public class ExceptionInterceptor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConnectException.class)
    public final ResponseEntity handleConnectException(
            ConnectException ex) {
        return new ResponseEntity("Unable to connect to internal service: " + ex.getMessage(), HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler({HttpClientErrorException.class, HttpServerErrorException.class})
    public final ResponseEntity handleClientOrServerExc(
            HttpStatusCodeException httpClientOrServerExc) {
        return new ResponseEntity(httpClientOrServerExc.getMessage(), httpClientOrServerExc.getStatusCode());
    }
}