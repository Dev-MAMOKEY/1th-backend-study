package com.task.RestAPIServer.controller;

import com.task.RestAPIServer.dto.PostResponse;
import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.service.PostServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {

    private final PostServiceImpl postService;

    // 단건 게시글 조회
    @GetMapping("{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") long id) {

        try {
            return ResponseEntity // 게시글 조회 후 Post -> PostResponse 변환 후 200 OK 상태 코드와 함께 반환
                    .ok(new PostResponse(postService.findById(id)));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build(); // 게시글이 없으면 404 Not Found 응답을 반환

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build(); // 500 Internal Server Error 반환
        }
    }

    // 전체 게시글 조회
    @GetMapping
    public ResponseEntity<Page<PostResponse>> getAllPosts(Pageable pageable) {

        try {
            Page<PostResponse> postsResponse = postService.findAllPosts(pageable)
                    .map(post -> new PostResponse(post));

            return ResponseEntity.ok(postsResponse);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    // 게시글 생성
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {

        try {
            Post createdPost = postService.save(request);

            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new PostResponse(createdPost));
        } catch (IllegalArgumentException e) {
            return ResponseEntity
                    .badRequest()
                    .build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    // 게시글 수정
    @PutMapping("{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable("id") long id,
            @RequestBody PostRequest postRequest
    ) {
        try {
            Post updatedPost = postService.update(id, postRequest);

            return ResponseEntity.ok(new PostResponse(updatedPost));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    // 게시글 삭제
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") long id) {
        try {
            postService.delete(id);

            return ResponseEntity.noContent().build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }
}
