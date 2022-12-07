package com.example.spring.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UnauthorizedAccessException.class)
    public ApiErrorClass handleUnauthorizedAccessException(UnauthorizedAccessException un){
        return new ApiErrorClass(un.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ApiErrorClass handleInvalidInputException(InvalidInputException un){
        return new ApiErrorClass(un.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
