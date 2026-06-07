package com.board.springdb.post.dto;


import lombok.Builder;

import java.time.LocalDateTime;

@Builder
    public record PostResponse(Long id , String title, String content, String userName, LocalDateTime createAt){}

