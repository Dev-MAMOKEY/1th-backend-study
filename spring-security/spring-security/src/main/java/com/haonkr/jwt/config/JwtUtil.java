package com.haonkr.jwt.config;

import com.haonkr.jwt.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.time.Instant;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey;
    private final long expirationMs;

    public JwtUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.expiration-ms}") long expirationMs
    ) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);

        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
        this.expirationMs = expirationMs;
    }

    // JWT 생성
    public String createToken(User user) {
        Instant now = Instant.now();

        return Jwts.builder()
                // JWT의 주체로 사용자 이름 저장
                .subject(user.getUsername())

                // 추가 정보 저장
                .claim("userId", user.getId())
                .claim("role", user.getRole())

                // 발급 시간
                .issuedAt(Date.from(now))

                // 만료 시간
                .expiration(Date.from(now.plusMillis(expirationMs)))

                // 비밀키로 서명
                .signWith(secretKey)

                // 문자열 JWT 생성
                .compact();
    }

    // JWT 검증 및 Claims 추출
    public Claims parseClaims(String token) {
        return Jwts.parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}
