package com.project.boardDB.service;

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
                .build();

        // DB 저장
        Post savedPost = postRepository.save(post);

        // DTO 변환 후 반환
        return changeToResponse(savedPost);
    }

    // 게시글 전체 조회 (페이징 적용)
    public Page<PostResponse> getAllPosts(Pageable pageable) {

        // 페이지 정보와 함께 게시글 조회
        Page<Post> postPage = postRepository.findAll(pageable);
        // Entity -> DTO 변환
        return postPage.map(post -> changeToResponse(post));
    }

    // 게시글 단건 조회
    public PostResponse getPost(Long id) {

        // 게시글 조회
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new PostNotFoundException());
        // DTO 변환 후 반환
        return changeToResponse(post);
    }

    // 게시글 수정
    @Transactional
    public PostResponse updatePost(Long id, PostRequest request) {

        // 수정할 게시글 조회
        Post post = postRepository.findById(id).orElseThrow(() -> new PostNotFoundException());

        // 제목이 변경된 경우에만 중복 검사
        if (postRepository.existsByTitle(request.title()) && !post.getTitle().equals(request.title())) {
            throw new DuplicateTitleException();
        }

        // 게시글 수정
        post.update(request.title(), request.content());
        // DTO 변환 후 반환
        return changeToResponse(post);
    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id) {

        // 삭제할 게시글 조회
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