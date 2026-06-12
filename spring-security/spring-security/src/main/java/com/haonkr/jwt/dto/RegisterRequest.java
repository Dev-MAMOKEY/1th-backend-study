package com.haonkr.jwt.dto;

public record RegisterRequest(
        String username,
        String password
) { }
