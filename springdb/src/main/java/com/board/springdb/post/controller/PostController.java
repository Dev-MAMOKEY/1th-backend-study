package com.board.springdb.post.controller;

import com.board.springdb.global.rsdata.RsData;
import com.board.springdb.post.dto.PostNewRequest;
import com.board.springdb.post.dto.PostResponse;
import com.board.springdb.post.dto.PostUpdateRequest;
import com.board.springdb.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시물 등록
    @PostMapping
    public ResponseEntity<RsData<PostResponse>> newPost(@Valid  @RequestBody PostNewRequest requestDto){
        PostResponse postResponse = postService.newPost(requestDto);
        RsData<PostResponse> rsData = new RsData<>("201-1","게시물이 등록되었습니다",postResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    // 게시물 전체 조회
    /*@GetMapping
    public ResponseEntity<RsData<List<PostResponse>>> allPost(){
        List<PostResponse> allPost = postService.findAllPost();
        RsData<List<PostResponse>> rsData = new RsData<>("200-1","전체 게시물 조회가 완료되었습니다",allPost);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }*/

    // 게시물 단건 조회
    @GetMapping("/{id}")
    public ResponseEntity<RsData<PostResponse>> onePost(@PathVariable Long id){
        PostResponse postResponse = postService.findOnePost(id);
        RsData<PostResponse> rsData = new RsData<>("200-2","한개의 게시물 조회가 완료되었습니다",postResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    //게시물 수정
    @PutMapping("/{id}")
    public ResponseEntity<RsData<PostResponse>> updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest requestDto){
        PostResponse postResponse = postService.updatePost(requestDto,id);
        RsData<PostResponse> rsData = new RsData<>("200-3","게시물이 정상적으로 수정되었습니다",postResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    // 게시물 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<RsData<Void>> deletePost(@PathVariable Long id ){
        postService.deletePost(id);

        RsData<Void> rsData = new RsData<>("200-4", "게시물이 정상적으로 삭제되었습니다");
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }
    // 전체 조회하기 (페이징)
    @GetMapping
    public ResponseEntity<RsData<Page<PostResponse>>> getPost(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<PostResponse> postResponse = postService.getPostWithPaging(page, size);
        RsData<Page<PostResponse>> rsData = new RsData<>("200-5", (page + 1)+"페이지 조회가 완료되었습니다", postResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

}
