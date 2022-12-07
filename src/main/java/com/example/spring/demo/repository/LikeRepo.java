package com.example.spring.demo.repository;

import com.example.spring.demo.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface LikeRepo extends JpaRepository<Like,Long> {
    @Query(value="SELECT * FROM user_likes WHERE user_id=? AND post_id=?", nativeQuery = true)
    Optional<Like> findByUserIdAndPostId(Long userId, Long postId);
//    Optional<List<Like>> findAllByPostId(Long postId);
}
