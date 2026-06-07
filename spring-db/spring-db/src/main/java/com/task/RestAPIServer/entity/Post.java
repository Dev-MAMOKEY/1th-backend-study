package com.task.RestAPIServer.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


// Lombok을 통해 이 클래스의 필드에 대한 getter를 자동 생성
@Getter

// Lombok을 통해 이 클래스의 필드에 대한 setter를 자동 생성
@Setter

// 매개 변수가 없는 기본 생성자를 자동 생성, JPA가 Entity 객체를 생성할 때 기본 생성자가 필요
@NoArgsConstructor

// 이 클래스가 JPA Entity임을 나타내며, DB 테이블과 매핑되는 클래스
@Entity

// 이 Entity가 매핑될 DB 테이블 이름을 지정, posts 테이블과 매핑
@Table(name="posts")
public class Post extends GlobalEntity{

    // 이 필드가 테이블의 기본키(Primary Key)임을 의미
    @Id

    // 기본키 값을 자동으로 생성하도록 설정
    // enerationType.IDENTITY는 DB의 AUTO_INCREMENT 기능을 사용하여 id를 자동 증가
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    // title 필드를 DB의 post_title 컬럼과 매핑
    @Column(name = "post_title")
    private String title;

    // content 필드를 DB의 post_content 컬럼과 매핑
    @Column(name = "post_content")
    private String content;

    // 게시글을 생성할 때 제목과 내용을 받아 객체를 만들기 위한 생성자
    // id는 DB에 저장될 때 자동으로 생성되므로 생성자에서 받지 않음
    public Post(String title, String content) {
        // 전달받은 title 값을 현재 객체의 title 필드에 저장
        this.title = title;

        // 전달받은 content 값을 현재 객체의 content 필드에 저장
        this.content = content;
    }
}
