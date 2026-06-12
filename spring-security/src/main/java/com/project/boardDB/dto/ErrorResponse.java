package com.project.boardDB.dto;

// 에러 응답 DTO
// record: 데이터를 저장하고 전달하기 위한 불변 객체
public record ErrorResponse(
        String message,
        int status

        /* 원래 이거임
    public final class ErrorResponse {

    private final String message;
    private final int status;

    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String message() {
        return message;
    }

    public int status() {
        return status;
    }
}*/

){

}
