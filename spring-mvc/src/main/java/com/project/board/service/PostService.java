package com.project.board.service;

import com.project.board.dto.PostRequest;
import com.project.board.dto.PostResponse;
import com.project.board.entity.Post;
import com.project.board.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    // 게시글 생성
    public PostResponse createPost(PostRequest request) {

        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .createdAt(LocalDateTime.now())
                .build();

        return changeToResponse(postRepository.save(post));
    }

    // 전체 조회
    public List<PostResponse> getAllPosts() {

        List<Post> posts = postRepository.findAll();

        List<PostResponse> responseList = new ArrayList<>();

        for (Post post : posts) {
            responseList.add(changeToResponse(post));
        }

        return responseList;
    }

    // 단건 조회
    public PostResponse getPost(Long id) {

        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            return null;
        }

        return changeToResponse(post);
    }

    // 수정
    public PostResponse updatePost(Long id, PostRequest request) {

        Post post = postRepository.findById(id).orElse(null);

        if (post == null) {
            return null;
        }

        post.update(request.getTitle(), request.getContent());

        return changeToResponse(postRepository.save(post));
    }

    // 삭제
    public boolean deletePost(Long id) {

        if (!postRepository.existsById(id)) {
            return false;
        }

        postRepository.deleteById(id);

        return true;
    }

    // Entity -> DTO 변환
    private PostResponse changeToResponse(Post post) {

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createdAt(post.getCreatedAt())
                .build();
    }
}