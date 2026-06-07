package com.board.springdb.post.dto;

public record PostUpdateRequest(
        String title,
        String content
) {
}
