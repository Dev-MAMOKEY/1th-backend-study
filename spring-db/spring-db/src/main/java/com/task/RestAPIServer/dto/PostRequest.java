package com.task.RestAPIServer.dto;

// 게시글 생성 또는 수정 요청 데이터를 담기 위한 DTO
public record PostRequest(

        // 클라이언트가 요청으로 전달하는 게시글 제목
        String title,

        // 클라이언트가 요청으로 전달하는 게시글 내용
        String content
) {
}
