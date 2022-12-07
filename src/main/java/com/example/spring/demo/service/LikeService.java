package com.example.spring.demo.service;

import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;

public interface LikeService {
    ApiResponse likePost(Long userId, Long postId);
    PostDto getLikeCount(Long postId);
}
