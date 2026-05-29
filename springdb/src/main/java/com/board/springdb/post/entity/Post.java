package com.board.springdb.post.entity;

import com.board.springdb.comment.entity.Comment;
import com.board.springdb.global.BaseTimeEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long id;

    @Column(name = "title" ,length = 200, nullable = false)
    private String title;

    @Column(name = "content",length = 500, nullable = false)
    private String content;

    @Column(name = "userName",nullable = false)
    private String userName;


    @OneToMany(mappedBy = "post")
    List<Comment> comments = new ArrayList<>();

    @Builder
    public Post (String title, String content, String userName){
        this.title= title;
        this.content = content;
        this. userName = userName;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }









}
