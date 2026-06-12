package com.project.springsecurity.dto;

public record PostUpdateRequest(
        String title,
        String content
) {
}