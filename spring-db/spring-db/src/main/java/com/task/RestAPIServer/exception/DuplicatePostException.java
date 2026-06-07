package com.task.RestAPIServer.exception;


// 같은 제목과 내용의 게시글이 이미 존재할 때 사용할 사용자 정의 예외 클래스
// RuntimeException을 상속했기 때문에 실행 중 발생하는 예외로 처리
public class DuplicatePostException extends RuntimeException {

    // DuplicatePostException 객체를 생성할 때 호출되는 기본 생성자
    public DuplicatePostException() {

        // 부모 클래스인 RuntimeException의 생성자를 호출
        // 예외가 발생했을 때 e.getMessage()를 호출하면 "같은 제목과 내용의 게시글이 이미 존재합니다."가 반환
        super("같은 제목과 내용의 게시글이 이미 존재합니다.");
    }
}
