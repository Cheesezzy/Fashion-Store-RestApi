package com.example.spring.demo.controller;

import com.example.spring.demo.pojos.*;
import com.example.spring.demo.service.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/admin/register")
    public ApiResponse createAdmin(@RequestBody RegisterDto registerDto){
        return userService.createOwner(registerDto);
    }
    @PostMapping("/user/register")
    public ApiResponse createUser(@RequestBody RegisterDto registerDto){
        return userService.createUser(registerDto);
    }
    @PostMapping("/login")
    public ApiResponse loginUser(@RequestBody LoginDto loginDto){
        return userService.loginUser(loginDto);
    }
    @PostMapping("/logout")
    public ApiResponse<String> loginOutUser(){
        return new ApiResponse<>(userService.logOut(),true,null);
    }


}
