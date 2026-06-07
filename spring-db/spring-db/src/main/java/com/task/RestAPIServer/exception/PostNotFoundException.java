package com.task.RestAPIServer.exception;


// 게시글을 찾지 못했을 때 사용할 사용자 정의 예외 클래스
// RuntimeException을 상속했기 때문에 실행 중 발생하는 예외로 처리
public class PostNotFoundException extends RuntimeException {

    // PostNotFoundException 객체를 생성할 때 호출되는 생성자
    // 찾지 못한 게시글의 id를 매개변수로 받음
    public PostNotFoundException(Long id) {

        // 부모 클래스인 RuntimeException의 생성자를 호출
        // 예외가 발생했을 때 e.getMessage()를 호출하면 "해당 게시글이 존재하지 않습니다. id = 1" 같은 메시지 반환
        super("해당 게시글이 존재하지 않습니다. id = " + id);
    }

}
