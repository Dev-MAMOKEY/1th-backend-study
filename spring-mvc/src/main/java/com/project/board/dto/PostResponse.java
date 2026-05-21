package com.project.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class PostResponse {

    private long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
}
