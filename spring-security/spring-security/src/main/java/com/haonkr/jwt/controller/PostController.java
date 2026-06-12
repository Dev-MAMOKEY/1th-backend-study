package com.haonkr.jwt.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/posts")
public class PostController {

    @GetMapping
    public ResponseEntity<List<Map<String, Object>>> getPosts(Authentication authentication) {
        return ResponseEntity.ok(
                List.of(
                        Map.of(
                                "id", 1,
                                "title", "JWT 테스트 게시글의 제목",
                                "content", "JWT 테스트 게시글의 내용",
                                "username", authentication.getName()
                        )
                )
        );
    }
}
