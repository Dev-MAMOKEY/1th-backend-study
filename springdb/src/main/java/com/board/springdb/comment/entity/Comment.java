package com.board.springdb.comment.entity;


import com.board.springdb.global.BaseTimeEntity;
import com.board.springdb.post.entity.Post;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Comment")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long comment_Id;

    @Column(name = "userId", nullable = false)
    String commentUserName;

    @Column(name = "content", nullable = false)
    String commentContent;

    @JoinColumn(name = "board_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;


    @Builder
    public Comment(String commentContent,String commentUserName,Post post){
        this.commentContent =commentContent;
        this.commentUserName = commentUserName;
        this.post =post;
    }

    public void update(String commentContent){
        this.commentContent =commentContent;
    }




}
