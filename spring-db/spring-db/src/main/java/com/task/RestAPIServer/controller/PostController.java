package com.task.RestAPIServer.controller;

import com.task.RestAPIServer.dto.PostResponse;
import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

// final 필드를 대상으로 생성자를 자동 생성
// postService를 생성자 주입 방식으로 주입바기 위해 사용
@RequiredArgsConstructor

// 이 클래스가 REST API Controller임을 나타냄
// 반환값은 주로 JSON 형태로 응답
@RestController

// 이 Controller의 기본 URL 경로를 /posts로 설정
@RequestMapping("/posts")
public class PostController {

    // 게시글 관련 비즈니스 로직을 처리하는 Service
    // final로 선언했기 때문에 @RequiredArgsConstructor를 통해 생성자 주입
    private final PostService postService;

    // 단건 게시글 조회
    // GET /posts/{id} 요청 처리
    @GetMapping("{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable("id") long id) {

        // URL 경로에서 받은 id를 기준으로 게시글 조회, 로직은 Service 계층에서 처리
        Post post = postService.findById(id);

        // 조회한 Post Entity를 PostResponse DTO로 반환하여 HTTP 200 OK 상태 코드와 함께 반환
        return ResponseEntity.ok(new PostResponse(post));
    }

    // 전체 게시글 조회
    // GET /posts 요청 처리
    // Pagable을 통해 페이징 정보를 받음, 예) GET /posts?page=0&size=10
    @GetMapping
    public ResponseEntity<Page<PostResponse>> getAllPosts(Pageable pageable) {

        // Service에서 페이징 처리된 게시글 목록 조회, 조회 결과는 Page<Post> 형태
        // map(PostResponse::new)를 사용하여 각 Post를 PostResponse로 변환
        Page<PostResponse> postsResponse = postService.findAllPosts(pageable)
                .map(PostResponse::new);

        // 변환된 게시글 목록을 HTTP 200 OK 상태 코드와 함께 반환
        return ResponseEntity.ok(postsResponse);
    }

    // 게시글 생성
    // POST /posts 요청 처리
    @PostMapping
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {

        // PostRequest 데이터를 이용하여 게시글 생성, 저장 로직은 Service 계층에서 관리
        Post createdPost = postService.save(request);

        // 생성된 게시글을 PostResponse DTO로 변환하여 반환
        // 게시글 생성에 성공했으면 HTTP 201 CREATED 상태 코드를 사용
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new PostResponse(createdPost));
    }

    // 게시글 수정
    // PUT /posts/{id} 요청 처리
    @PutMapping("{id}")
    public ResponseEntity<PostResponse> updatePost(

            // URL 경로에서 수정할 게시글의 id를 가져옴
            @PathVariable("id") long id,

            // 요청 본문에서 수정할 제목, 내용 등의 데이터를 가져옴
            @RequestBody PostRequest postRequest
    ) {

        // id에 해당하는 게시글을 postRequest의 내용으로 수정, 수정 로직은 Service 계층에서 관리
        Post updatedPost = postService.update(id, postRequest);

        // 수정된 게시글을 PostResponse DTO로 변환하여 HTTP 200 OK 상태 코드와 함께 반환
        return ResponseEntity.ok(new PostResponse(updatedPost));
    }

    // 게시글 삭제
    // DELETE /posts/{id} 요청 처리
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") long id) {

        // id에 해당하는 게시글을 삭제, 삭제 로직은 Service 계층에서 관리
        postService.delete(id);

        // 삭제 성공 시 응답 본문 없이 HTTP 204 No Content 상태 코드 반환
        return ResponseEntity.noContent().build();
    }
}
