package com.example.spring.demo.service;

import com.example.spring.demo.pojos.LoginDto;
import com.example.spring.demo.pojos.RegisterDto;
import com.example.spring.demo.pojos.ApiResponse;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    ApiResponse createOwner (RegisterDto adminRegisterDto);
    ApiResponse createUser (RegisterDto adminRegisterDto);
    ApiResponse loginUser(LoginDto adminLoginDto);
}
