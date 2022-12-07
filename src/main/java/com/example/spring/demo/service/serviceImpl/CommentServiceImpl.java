package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.entity.Comment;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.exception.InvalidInputException;
import com.example.spring.demo.exception.UnauthorizedAccessException;
import com.example.spring.demo.pojos.CommentDto;
import com.example.spring.demo.repository.CommentRepo;
import com.example.spring.demo.repository.PostRepo;
import com.example.spring.demo.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Comment> getCommentByPostId(Long postId) {
        return commentRepo.findAllByPostId(postId).orElse(new ArrayList<>());
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {

        Comment comment = new Comment();
        comment.setMessage(commentDto.getMessage());
        Post post = postRepo.findById(postId).orElseThrow(()-> {
            throw new InvalidInputException("product not found","contact Admin");
        });

        comment.setPost(post);

        comment = commentRepo.save(comment);
        commentDto.setCommentId(comment.getCommentId());
        commentDto.setMessage(comment.getMessage());
        commentDto.setPost(comment.getPost());

        return commentDto;
    }


//    @Override
//    public ApiResponse viewPostById(Long id) {
//        UserCommentEntity commentEntity = userCommentsRepo.findById(id).orElse(null);
//
//        if (commentEntity != null){
//            commentEntity.set
//        }
//
//        return null;
//    }
}
