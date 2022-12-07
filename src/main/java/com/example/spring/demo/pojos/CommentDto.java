package com.example.spring.demo.pojos;

import com.example.spring.demo.entity.Post;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long commentId;
    private String message;
    private Post post;
}
