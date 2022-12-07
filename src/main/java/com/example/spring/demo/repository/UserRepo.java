package com.example.spring.demo.repository;

import com.example.spring.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);
    boolean existsByUserIdAndRole(Long userId, String role);


}
