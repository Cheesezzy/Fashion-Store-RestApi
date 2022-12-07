package com.example.spring.demo.service;

import com.example.spring.demo.enums.Title;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;

import java.util.List;

public interface PostService {
    PostDto createPost(PostDto postDto, Long userId);


    ApiResponse getAllPost();

    ApiResponse updatePost(Long postId, PostDto postDto);

    ApiResponse deletePost(Long postId);

    PostDto getPostById(Long postId);

    ApiResponse viewPostByTitle(Title title);
}
