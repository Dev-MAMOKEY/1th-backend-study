package com.task.RestAPIServer.exception;

import com.task.RestAPIServer.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

// 로그 객체를 자동으로 생성
// log.error("메시지", e)처럼 로그 남기기 가능
@Slf4j

// 전역 예외 처리 클래스임을 나타냄
// Controller에서 발생한 예외를 이 클래스에서 공통 처리
// @ControllerAdvice + @ResponseBody의 역할을 하며 JSON 형태의 응답 본문으로 전달
@RestControllerAdvice
public class GlobalExceptionHandler {

    // PostNotFoundException 예외가 발생했을 때 이 메소드 실행
    // 예: 존자하지 않는 게시글 조회, 수정, 삭제 시도
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlePostNotFoundException(PostNotFoundException e) {

        // 클라이언트에 반환할 에러 응답 DTO 생성
        ErrorResponse response = new ErrorResponse(

                // HTTP 상태 코드 숫자, NOT_FOUND는 404
                HttpStatus.NOT_FOUND.value(),

                // HTTP 상태 코드 이름, NOT_FOUND
                HttpStatus.NOT_FOUND.name(),

                // 예외 객체에 들어 있는 메시지를 응답에 포함
                // 예: "해당 게시글을 찾을 수 없습니다."
                e.getMessage(),

                // 에러가 발생한 현재 시간을 응답에 포함
                LocalDateTime.now()
        );

        // HTTP 404 Not Found 상태 코드와 함께 ErrorResponse를 응답 본문으로 반환
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    // PDuplicatePostException 예외가 발생했을 때 이 메소드 실행
    // 예: 같은 제목과 내용의 게시글 중복 생성
    @ExceptionHandler(DuplicatePostException.class)
    public ResponseEntity<ErrorResponse> handleDuplicatePostException(DuplicatePostException e) {

        // 클라이언트에 반환할 에러 응답 DTO 생성
        ErrorResponse response = new ErrorResponse(
                // HTTP 상태 코드 숫자, BAD_REQUEST는 400
                HttpStatus.BAD_REQUEST.value(),

                // HTTP 상태 코드 이름, BAD_REQUEST
                HttpStatus.BAD_REQUEST.name(),

                // 예외 객체에 들어있는 메시지를 응답에 포함
                // 예: "같은 제목과 내용의 게시글이 이미 존재합니다."
                e.getMessage(),

                // 에러가 발생한 현재 시간을 응답에 포함
                LocalDateTime.now()
        );

        // HTTP 400 Bad Request 상태 코드와 함께 ErrorResponse를 응답 본문으로 반환
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    // 위에서 따로 처리하지 않은 모든 예외를 처리하는 메소드
    // Exception은 대부분의 예외 클래스의 상위 클래스로, 예상치 못한 서버 오류를 마지막에 처리
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {

        // 서버 내부 오류 내용을 로그로 남김
        log.error("서버 내부 오류 발생", e);

        // 클라이언트에 반환할 에러 응답 DTO를 생성
        ErrorResponse response = new ErrorResponse(
                // HTTP 상태 코드 숫자, INTERNAL_SERVER_ERROR는 500
                HttpStatus.INTERNAL_SERVER_ERROR.value(),

                // HTTP 상태 코드 이름, INTERNAL_SERVER_ERROR
                HttpStatus.INTERNAL_SERVER_ERROR.name(),

                // 클라이언트에 보여줄 일반적인 오류 메시지
                "서버 내부 오류가 발생했습니다.",

                // 에러가 발생한 현재 시간을 응답에 포함
                LocalDateTime.now()
        );

        // HTTP 500 Internal Server Error 상태 코드와 함께 ErrorResponse를 응답 본문으로 반환
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}
