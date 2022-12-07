package com.example.spring.demo.converter;

import com.example.spring.demo.entity.Post;
import com.example.spring.demo.entity.User;
import com.example.spring.demo.pojos.PostDto;
import com.example.spring.demo.pojos.RegisterDto;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClassConverter {
    public User convertDTOtoEntity(RegisterDto registerDto){
        User entity = new User();
        entity.setUserName(registerDto.getUserName());
        entity.setEmail(registerDto.getEmail());
        entity.setPhoneNumber(registerDto.getPhoneNumber());
        entity.setPassword(registerDto.getPassword());
        entity.setCreatedAt(new Date());

        return entity;
    }

    public Post convertPostDTOtoEntity(PostDto postDto){
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setCategory(postDto.getCategory());
        post.setDescription(postDto.getDescription());
        post.setPrice(postDto.getPrice());

        return post;
    }
}
