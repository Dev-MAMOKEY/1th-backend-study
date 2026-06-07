package com.board.springdb.comment.dto;

public record CommentRequest(
        String commentUserName, // 작성자 이름
        String commentContent
) {
}