package com.project.springsecurity.global.exception;

import com.project.springsecurity.global.RsData.RsData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RsData<Void>> handleIllegalArgumentException(IllegalArgumentException e) {

        RsData<Void> rsData = new RsData<>("404-1", e.getMessage());  // 메시지 그대로 사용

        return ResponseEntity
                .status(rsData.statusCode())
                .body(rsData);
    }
// 중복 회원
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<RsData<Void>> handleIllegalStateException(IllegalStateException e) {
        RsData<Void> rsData = new RsData<>("409-1", e.getMessage());
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }
// 찾을 수 없음
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<RsData<Void>> handleNoSuchElementException(NoSuchElementException e) {
        RsData<Void> rsData = new RsData<>("404-1", e.getMessage());
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }
}