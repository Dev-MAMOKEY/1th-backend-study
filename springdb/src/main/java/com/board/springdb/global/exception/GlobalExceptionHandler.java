package com.board.springdb.global.exception;

import com.board.springdb.global.rsdata.RsData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<RsData<Void>> handleIllegalArgumentException(IllegalArgumentException e) {

        RsData<Void> rsData = new RsData<>("400-1", "존재하지 않는 게시물입니다.");

        return ResponseEntity
                .status(rsData.statusCode())
                .body(rsData);
    }
}