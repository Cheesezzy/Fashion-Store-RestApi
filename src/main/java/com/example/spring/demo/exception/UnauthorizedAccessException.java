package com.example.spring.demo.exception;

public class UnauthorizedAccessException extends RuntimeException {
    private String debugMessage;

    public UnauthorizedAccessException(String errorMessage, String debugMessage){
        super(errorMessage);
        this.debugMessage = debugMessage;
    }
}
