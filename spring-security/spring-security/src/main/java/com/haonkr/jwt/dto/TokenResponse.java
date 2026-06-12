package com.haonkr.jwt.dto;

public record TokenResponse(
        String token,
        String tokenType
) { }
