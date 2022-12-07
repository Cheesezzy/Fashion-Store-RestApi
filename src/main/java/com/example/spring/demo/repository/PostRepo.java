package com.example.spring.demo.repository;

import com.example.spring.demo.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    @Query(value = "SELECT * FROM user_post WHERE title=?", nativeQuery = true)
    List<Post> viewByTitle(String title);
}
