package com.example.spring.demo.entity;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long userId;
    private String userName;

    @Column(unique = true)
    private String email;

    private String role;
    private String phoneNumber;
    private String password;

    @CreationTimestamp
    private Date createdAt;

}
