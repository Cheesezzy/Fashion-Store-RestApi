package com.example.spring.demo.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userLikes")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(nullable = false)
    private Long likeId;
    private Long userId;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "post_id",referencedColumnName = "postId")
    private Post post;
}
