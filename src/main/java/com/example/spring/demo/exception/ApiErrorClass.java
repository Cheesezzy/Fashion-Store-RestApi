package com.example.spring.demo.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public class ApiErrorClass {

    private String message;
    private HttpStatus statusCode;

}
