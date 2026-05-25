package com.project.board.controller;

import com.project.board.dto.PostRequest;
import com.project.board.dto.PostResponse;
import com.project.board.service.PostService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(
            @RequestBody PostRequest request
    ) {

        PostResponse response = postService.createPost(request);

        // 제목 중복 확인 추가
        if (response == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build(); // 409에러 뜸
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 전체 조회
    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {

        return ResponseEntity.ok(postService.getAllPosts());
    }

    // 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {

        PostResponse response = postService.getPost(id);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    // 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable Long id,
            @RequestBody PostRequest request
    ) {

        PostResponse response = postService.updatePost(id, request);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(response);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {

        boolean result = postService.deletePost(id);

        if (!result) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}