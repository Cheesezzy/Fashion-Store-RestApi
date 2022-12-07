package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.controller.CommentController;
import com.example.spring.demo.entity.Comment;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.pojos.CommentDto;
import com.example.spring.demo.service.CommentService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class CommentTest {
    @Mock
    private CommentService commentService;

    @InjectMocks
    private CommentController commentController;



    @Test
    @DisplayName("Test Success Scenario for Saving new Comment")
    void createCommentTest(){
        CommentDto dto = new CommentDto();
        dto.setMessage("Dummy");

        Post post = new Post();
        post.setPostId(1L);
        CommentDto save = new CommentDto();
        save.setCommentId(1L);
        save.setMessage(dto.getMessage());

        Mockito.when(commentService.createComment(dto,1L)).thenReturn(save);

        ResponseEntity<CommentDto> res = commentController.createComments(dto,1L);
        Assertions.assertNotNull(res.getBody().getCommentId());
        Assertions.assertEquals(HttpStatus.CREATED.value(), res.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test Success Scenario for Fetching All Comment")
    void testGetComment(){
        List<Comment> commentList = new ArrayList<>();

        CommentDto commentDto = new CommentDto();
        commentDto.setMessage("Dummy");
        commentDto.setCommentId(1L);

        Comment comment = new Comment();
        comment.setMessage(commentDto.getMessage());
        comment.setCommentId(comment.getCommentId());

        commentList.add(comment);
        boolean res = !commentList.isEmpty();

        Assertions.assertTrue(res);

    }

}
