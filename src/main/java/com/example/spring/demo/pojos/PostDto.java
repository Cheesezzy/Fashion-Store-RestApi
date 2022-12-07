package com.example.spring.demo.pojos;

import com.example.spring.demo.entity.Comment;
import com.example.spring.demo.enums.Title;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {
    private Long Id;
    private Title title;
    private String category;
    private String description;
    private Double price;
    private Integer numberOfLikes;

}
