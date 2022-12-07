package com.example.spring.demo.pojos;


import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LikeDto {
    private Long likeId;
    private Long userId;
    private Long postId;
}
