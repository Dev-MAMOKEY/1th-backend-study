package com.project.boardDB.exception;

public class DuplicateTitleException extends RuntimeException {
    public DuplicateTitleException() {
        super("이미 존재하는 제목입니다.");

    }
}