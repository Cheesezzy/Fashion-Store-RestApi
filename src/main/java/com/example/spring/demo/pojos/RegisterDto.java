package com.example.spring.demo.pojos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {
    private String userName;
    private String email;
    private String phoneNumber;
    private String password;
}
