package com.board.springdb.post.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;



public record PostNewRequest(
        @Size(max = 200, message = "200자 까지만 가능합니다")
        String title,
        @Size(max = 500, message = "500자 까지만 가능합니다")
        String content,
        String userName
) {
}
