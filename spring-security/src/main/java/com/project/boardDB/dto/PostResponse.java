package com.project.boardDB.dto;

import java.time.LocalDateTime;

public record PostResponse(
        Long id,
        String title,
        String content,
        LocalDateTime createdAt

) {
}
