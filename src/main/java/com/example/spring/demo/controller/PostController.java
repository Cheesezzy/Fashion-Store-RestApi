package com.example.spring.demo.controller;

import com.example.spring.demo.enums.Title;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class PostController {

    @Autowired
    private PostService postService;


    @PostMapping("/posts/{userId}")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable Long userId){
        postDto = postService.createPost(postDto, userId);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }
    @GetMapping("/all-posts")
    public ApiResponse getAllPost(){
        return postService.getAllPost();
    }
    @GetMapping("/view/{title}")
    public ApiResponse viewByTitle(@PathVariable Title title){
        return postService.viewPostByTitle(title);
    }

    @PutMapping("/update-post/{postId}")
    public ApiResponse updatePost(@PathVariable Long postId, @RequestBody PostDto postDto){
        return postService.updatePost(postId,postDto);
    }
    @DeleteMapping("/delete-post/{postId}")
    public ApiResponse DeletePost(@PathVariable Long postId){
        return postService.deletePost(postId);
    }


}
