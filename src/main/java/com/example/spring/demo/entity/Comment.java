package com.example.spring.demo.entity;


import lombok.*;

import javax.persistence.*;


@Entity
@Table(name = "user_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String message;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id",referencedColumnName = "postId")
    private Post post;
}
