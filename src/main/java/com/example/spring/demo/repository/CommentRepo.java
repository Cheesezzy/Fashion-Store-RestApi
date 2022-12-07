package com.example.spring.demo.repository;

import com.example.spring.demo.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CommentRepo extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM user_comment WHERE post_id=?", nativeQuery = true)
    Optional <List<Comment>> findAllByPostId(Long postId);

//    boolean existsByPostId(Long postId);
}
