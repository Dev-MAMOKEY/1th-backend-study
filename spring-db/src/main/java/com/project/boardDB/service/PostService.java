package com.project.boardDB.service;

import com.project.boardDB.dto.PostPageResponse;
import com.project.boardDB.dto.PostRequest;
import com.project.boardDB.dto.PostResponse;
import com.project.boardDB.entity.Post;
import com.project.boardDB.exception.DuplicateTitleException;
import com.project.boardDB.exception.PostNotFoundException;
import com.project.boardDB.repository.PostRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final PostRepository postRepository;

    // 게시글 생성
    @Transactional
    public PostResponse createPost(PostRequest request) {

        // 제목 중복 확인
        if (postRepository.existsByTitle(request.title())) {
            throw new DuplicateTitleException();
        }

        // 게시글 객체 생성
        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .createdAt(LocalDateTime.now())
                .build();

        // DB 저장
        Post savedPost = postRepository.save(post);

        // DTO 변환 후 반환
        return changeToResponse(savedPost);
    }

    // 게시글 전체 조회 (페이징 사용)
    public PostPageResponse getAllPosts(Pageable pageable) {

        // 페이징 조회
        Page<Post> postPage = postRepository.findAll(pageable);

        // Entity -> DTO 변환 리스트
        List<PostResponse> responseList = new ArrayList<>();

        for (Post post : postPage.getContent()) {
            responseList.add(changeToResponse(post));
        }

        // 게시글 목록 + 페이징 정보 반환
        return new PostPageResponse(
                responseList,
                postPage.getNumber(),
                postPage.getSize(),
                postPage.getTotalElements(),
                postPage.getTotalPages(),
                postPage.isFirst()
        );


    }

    // 게시글 단건 조회
    public PostResponse getPost(Long id) {

        // 게시글 조회
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());

        return changeToResponse(post);
    }

    // 게시글 수정
    @Transactional
    public PostResponse updatePost(Long id, PostRequest request) {

        // 게시글 조회부터
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());

        // 수정 시 제목 중복 확인
        if (postRepository.existsByTitle(request.title())) {
            throw new DuplicateTitleException();
        }

        // 게시글 수정
        post.update(request.title(), request.content());
        return changeToResponse(post);
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id) {

        // 게시글 조회
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());

        // 게시글 삭제
        postRepository.delete(post);
    }

    // Entity -> DTO 변환
    private PostResponse changeToResponse(Post post) {

        return new PostResponse(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getCreatedAt()
        );

    }





}