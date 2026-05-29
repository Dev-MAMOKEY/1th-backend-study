package com.task.RestAPIServer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="posts")
public class Post {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name = "post_title")
    private String title;

    @Column(name = "post_content")
    private String content;

    @Column(name = "post_createdAt")
    private LocalDateTime createdAt;

    public Post() {}

    public Post(String title, String content, LocalDateTime createdAt) {
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
    }
}
