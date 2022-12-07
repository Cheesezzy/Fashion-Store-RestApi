package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.pojos.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public class ResponseManager<T> {
    public ApiResponse<T> success(T data){
        return new ApiResponse<>("Request successful",true,data);
    }

    public ApiResponse<T> error(String errorMessage){
        return new ApiResponse<>(errorMessage,false,null);
    }
}
