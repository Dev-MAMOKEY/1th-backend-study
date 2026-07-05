package com.project.springsecurity.service;


import com.project.springsecurity.dto.PostNewRequest;
import com.project.springsecurity.dto.PostResponse;
import com.project.springsecurity.dto.PostUpdateRequest;
import com.project.springsecurity.entity.Post;
import com.project.springsecurity.entity.UserEntity;
import com.project.springsecurity.repository.PostRepository;
import com.project.springsecurity.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    private UserEntity getUser(){
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username).orElseThrow(()->new NoSuchElementException("유저를 찾을 수 없습니다."));

    }
    // 게시물 생성
    @Transactional
    public PostResponse newPost(PostNewRequest request){
        UserEntity user = getUser();

        Post post = Post.builder()
                .title(request.title())
                .content(request.content())
                .user(user)  // userName -> user
                .build();

        Post savePost = postRepository.save(post);
        return PostResponse.builder().
                id(savePost.getId()).
                title(savePost.getTitle()).
                content(savePost.getContent()).
                username(post.getUser().getUsername()).
                createdAt(savePost.getCreateAt())
                .build();
    }

    // 게시물 수정
    @Transactional
    public PostResponse updatePost(PostUpdateRequest request, Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("게시글을 찾을 수 없습니다."));
        post.update(request.title(), request.content());
        return PostResponse.builder().
                id(post.getId()).
                title(post.getTitle()).
                content(post.getContent()).
                username(post.getUser().getUsername()).
                createdAt(post.getCreateAt())
                .build();
    }

    // 단건 조회
    public PostResponse findOnePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        return PostResponse.builder().
                id(post.getId()).
                title(post.getTitle()).
                content(post.getContent()).
                username(post.getUser().getUsername()).
                createdAt(post.getCreateAt())
                .build();
    }

    // 단건 삭제
    @Transactional
    public void deletePost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글을 찾을 수 없습니다."));
        postRepository.delete(post);
    }

    //페이지 전체 조회
    public Page<PostResponse> getPostWithPaging(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return postRepository.findAll(pageable)
                .map(post -> PostResponse.builder().
                        id(post.getId()).
                        title(post.getTitle()).
                        content(post.getContent()).
                        username(post.getUser().getUsername()).
                        createdAt(post.getCreateAt())
                        .build());




}
}