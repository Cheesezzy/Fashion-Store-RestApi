package com.example.spring.demo.controller;

import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/like")
public class LikeController {
    @Autowired
    private LikeService likeService;


    @PostMapping("/{userId}/{postId}")
    public ApiResponse likePost(@PathVariable Long userId, @PathVariable Long postId ){
        return likeService.likePost(userId, postId);
    }

    @GetMapping("/{postId}/get-like-count")
    public PostDto getLikeCount(@PathVariable Long postId){
       return likeService.getLikeCount(postId);
    }
}
