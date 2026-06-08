package com.project.boardDB.controller;

import com.project.boardDB.dto.PostRequest;
import com.project.boardDB.dto.PostResponse;
import com.project.boardDB.service.PostService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {
        // 게시글 생성
        PostResponse response = postService.createPost(request);
        // 게시글 생성 성공시 201 반환
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    // 게시글 전체 조회
    @GetMapping
    public ResponseEntity<Page<PostResponse>> getAllPosts(
            // 기본값: 10개씩 조회, id기준 내림차순 정렬
            @PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC)
            Pageable pageable
    ) {
        return ResponseEntity.ok(postService.getAllPosts(pageable));
    }

    // 게시글 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return ResponseEntity.ok(postService.getPost(id));
    }

    // 게시글 수정
    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@PathVariable Long id, @RequestBody PostRequest request) {
        return ResponseEntity.ok(postService.updatePost(id, request));
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) {
        postService.deletePost(id);
        // 게시글 삭제 성공 시 204 반환
        return ResponseEntity.noContent().build();
    }
}