package com.project.springsecurity.dto;

import lombok.Getter;


public record LoginDto(
        String username,
        String password
) {
}