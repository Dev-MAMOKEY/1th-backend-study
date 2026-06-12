package com.haonkr.jwt.dto;

public record LoginRequest(
        String username,
        String password
) { }
