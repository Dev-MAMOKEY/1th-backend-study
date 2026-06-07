package com.task.RestAPIServer.dto;

import com.task.RestAPIServer.entity.Post;

import java.time.LocalDateTime;

// 게시글 응답 데이터를 담기 위한 DTO로 클라이언트에 게시글 정보를 반환할 때 사용
public record PostResponse(

        // 게시글의 고유 ID
        Long id,

        // 게시글의 제목
        String title,

        // 게시글의 내용
        String content,

        // 게시글이 생성된 시간
        LocalDateTime createdAt,

        // 게시글이 마지막으로 수정된 시간
        LocalDateTime updatedAt
) {
    // Post Entity 객체를 PostResponse DTO로 변환하기 위한 생성자
    // Controller에서 new PostResponse(post)처럼 사용할 수 있게 함
    public PostResponse(Post post) {

        // record의 기본 생성자를 호출
        this(
                // Post Entity의 id 값을 가져와 PostResponse의 id에 넣음
                post.getId(),

                // Post Entity의 title 값을 가져와 PostResponse의 title에 저장
                post.getTitle(),

                // Post Entity의 content 값을 가져와 PostResponse의 content에 저장
                post.getContent(),

                // Post Entity의 createdAt 값을 가져와 PostResponse의 createdAt에 저장
                post.getCreatedAt(),

                // Post Entity의 updatedAt 값을 가져와 PostResponse의 updatedAt에 저장
                post.getUpdatedAt()
        );
    }
}