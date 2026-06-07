package com.board.springdb.comment.dto;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record CommentResponse(
       Long commentId,
       String commentUserName, // 작성자 이름
       String commentContent,
       Long boardId,
       LocalDateTime createAt

) {
}