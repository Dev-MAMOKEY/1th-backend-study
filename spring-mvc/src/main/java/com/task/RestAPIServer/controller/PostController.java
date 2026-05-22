package com.task.RestAPIServer.controller;

import com.task.RestAPIServer.dto.PostResponse;
import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.service.PostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostServiceImpl postService;

    // 단건 게시글 조회
    @GetMapping("/posts/{id}")
    public ResponseEntity<Optional<PostResponse>> getPostById(@PathVariable("id") long id) {

        try {
            Optional<PostResponse> postResponse = postService.findById(id)
                    .map(post -> new PostResponse(post)); // Optional 안의 Post 객체를 PostResponse로 변환, 생성자 참조

            return ResponseEntity.ok(postResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 전체 게시글 조회
    @GetMapping("/posts")
    public ResponseEntity<List<PostResponse>> getAllPosts() {

        try {
            List<PostResponse> postsResponse = postService.findAllPosts()
                    .stream() // List<Post> -> Stream<Post>
                    .map(posts -> new PostResponse(posts)) // Post -> PostResponse
                    .toList(); // Stream<PostResponse> -> List<PostResponse>

            return ResponseEntity.ok(postsResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 게시글 생성
    @PostMapping("/posts")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest request) {

        Post createdPost = postService.save(request);
        try {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new PostResponse(createdPost));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 게시글 수정
    @PutMapping("/posts/{id}")
    public ResponseEntity<PostResponse> updatePost(
            @PathVariable("id") long id,
            @RequestBody PostRequest postRequest
    ) {
        try {
            Post updatedPost = postService.update(id, postRequest);

            return ResponseEntity.ok(new PostResponse(updatedPost));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 게시글 삭제
    @DeleteMapping("/posts/{id}")
    public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") long id) {
        try {
            postService.delete(id);

            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
