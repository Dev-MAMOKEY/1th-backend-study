package com.project.boardDB.dto;

public record AuthRequest(
        String username,
        String password
) {
}