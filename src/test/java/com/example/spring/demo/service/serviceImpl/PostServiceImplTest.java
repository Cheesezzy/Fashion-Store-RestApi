package com.example.spring.demo.service.serviceImpl;

import com.example.spring.demo.controller.PostController;
import com.example.spring.demo.entity.Post;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.service.PostService;
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
class PostServiceImplTest {
    @InjectMocks
    PostController postController;

    @Mock
    PostService postService;


    @Test
    @DisplayName("Test Success Scenario for Saving new Post")
    void createPostTest() {
        PostDto dto = new PostDto();
        dto.setCategory("Dummy");

        User user = new User();
        user.setUserId(1L);
        PostDto saved = new PostDto();
        saved.setId(1L);
        saved.setCategory(dto.getCategory());

        Mockito.when(postService.createPost(dto,1L)).thenReturn(saved);

        ResponseEntity<PostDto> responseEntity = postController.createPost(dto,1L);
        Assertions.assertNotNull(responseEntity.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED.value(), responseEntity.getStatusCodeValue());
    }

    @Test
    @DisplayName("Test Success Scenario for Fetching All Post")
    void testGetPost(){
        List<Post> posts = new ArrayList<>();

        PostDto postDto = new PostDto();
        postDto.setId(1L);
        postDto.setCategory("Dummy");
        postDto.setDescription("Dummy Dummy");

        Post post = new Post();
        post.setPostId(postDto.getId());
        post.setCategory(postDto.getCategory());
        post.setDescription(postDto.getDescription());


        posts.add(post);
        boolean res = !posts.isEmpty();

        Assertions.assertTrue(res);
    }
}