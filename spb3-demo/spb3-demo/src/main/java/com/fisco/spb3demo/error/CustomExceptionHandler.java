package com.fisco.spb3demo.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.reactive.function.client.WebClientResponseException;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({RuntimeException.class, HttpClientErrorException.NotFound.class})
    public ProblemDetail onRunTimeException(RuntimeException ex){
       ProblemDetail detail= ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,ex.getMessage());
       detail.getType();
       return detail;
    }
}
