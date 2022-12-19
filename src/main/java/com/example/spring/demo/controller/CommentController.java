package com.example.spring.demo.controller;

import com.example.spring.demo.entity.Comment;
import com.example.spring.demo.pojos.CommentDto;
import com.example.spring.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class CommentController { // controller comment
    @Autowired
    private CommentService commentService;


    @PostMapping("/comments/{postId}")
    public ResponseEntity<CommentDto> createComments(@RequestBody CommentDto commentDto, @PathVariable Long postId){
        commentDto = commentService.createComment(commentDto,postId);
        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);
    }

//    @PostMapping("/{postId}/comment/new")
//    public CommentDto createNewComments(@RequestBody CommentDto commentDto, @PathVariable Long postId){
//        return commentDto;
//    }

    @GetMapping("/{postId}")
    public List<Comment> getComments(@PathVariable Long postId){
        List<Comment> comments = commentService.getCommentByPostId(postId);
        return comments;
    }
}
