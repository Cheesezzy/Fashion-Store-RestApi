package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.entity.Like;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.exception.InvalidInputException;
import com.example.spring.demo.pojos.ApiResponse;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.repository.LikeRepo;
import com.example.spring.demo.repository.PostRepo;
import com.example.spring.demo.service.LikeService;
import com.example.spring.demo.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepo likeRepo;

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private PostService postService;

    @Override
    public ApiResponse likePost(Long userId, Long postId) {
        String message = null;
        Like like = likeRepo.findByUserIdAndPostId(userId,postId).orElse(null);
        Post post = postRepo.findById(postId).orElseThrow(() -> new InvalidInputException("", ""));
        if (like == null){
            Like like1 = Like.builder()
                    .post(post)
                    .userId(userId)
                    .build();
            likeRepo.save(like1);
            message = "Post Liked Successfully";
        }
        else {
            likeRepo.delete(like);
            message = "Post unLiked ";
        }
        return new ApiResponse(message,true,postService.getPostById(postId));
    }

    @Override
    public PostDto getLikeCount(Long postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new InvalidInputException("Invalid", "Contact Admin"));
        PostDto postDto = PostDto.builder()
                .Id(postId)
                .price(post.getPrice())
                .category(post.getCategory())
                .description(post.getDescription())
                .numberOfLikes(post.getLikes().size())
                .build();
        return postDto;

    }
}
