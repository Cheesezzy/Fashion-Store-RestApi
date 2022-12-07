package com.example.spring.demo.exception;

public class InvalidInputException extends RuntimeException {
    private String debugMessage;

    public InvalidInputException(String errorMessage, String debugMessage){
        super(errorMessage);
        this.debugMessage = debugMessage;
    }
}
