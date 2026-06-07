package com.task.RestAPIServer.dto;

import java.time.LocalDateTime;

// 에러 응답 정보를 담기 위한 DTO
// record는 생성자, getter 역할의 메소드, equals(), toString() 등이 자동 생성
public record ErrorResponse (

        // HTTP 상태 코드를 의미
        int status,

        // 에러의 종류 또는 상태 문구를 의미
        String error,

        // 클라이언트에 보여줄 구체적인 에러 메시지
        String message,

        // 에러가 발생한 시간
        LocalDateTime timestamp
) {}
