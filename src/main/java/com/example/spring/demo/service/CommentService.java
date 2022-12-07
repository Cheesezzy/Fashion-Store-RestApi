package com.example.spring.demo.service;

import com.example.spring.demo.entity.Comment;
import com.example.spring.demo.pojos.CommentDto;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByPostId(Long postId);
    CommentDto createComment(CommentDto commentDto, Long postId);
}
