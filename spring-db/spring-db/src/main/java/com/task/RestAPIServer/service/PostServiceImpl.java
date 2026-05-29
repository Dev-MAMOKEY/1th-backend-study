package com.task.RestAPIServer.service;

import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    // 게시글 생성
    @Override
    public Post save(PostRequest postRequest) {

        try {
            if (postRepository.existsByTitleAndContent(postRequest.title(), postRequest.content())) {
                throw new IllegalArgumentException("같은 제목과 내용의 게시글이 이미 존재합니다.");
            }
            return postRepository.save(
                    new Post(
                            postRequest.title(),
                            postRequest.content(),
                            LocalDateTime.now()
                    )
            );
        } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            e.printStackTrace(); // 로그 확인용
            throw new RuntimeException("게시글 생성 중 오류가 발생하였습니다.", e);
        }
    }

    // 단건 게시글 조회
    @Override
    public Post findById(Long id) {

        try {
            return postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));
            } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 조회 중 오류가 발생했습니다.", e);
        }
    }

    // 전체 게시글 조회
    @Override
    public Page<Post> findAllPosts(Pageable pageable) {

        try {
            return postRepository.findAll(pageable);

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 조회 중 오류가 발생하였습니다.", e);
        }
    }

    // 게시글 수정
    @Override
    public Post update(Long id, PostRequest postRequest) {

        try {
            Post postData = postRepository.findById(id)
                    .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id));

            postData.setTitle(postRequest.title());
            postData.setContent(postRequest.content());
            postData.setCreatedAt(LocalDateTime.now());
            postRepository.save(postData);
            return postData;
        } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 수정 중 오류가 발생했습니다.", e);
        }
    }

    // 게시글 삭제
    @Override
    public void delete(Long id) {

        try {
            if (!postRepository.existsById(id)) {
                throw new IllegalArgumentException("해당 게시글이 존재하지 않습니다. id = " + id);
            }

            postRepository.deleteById(id);

        } catch (IllegalArgumentException e) {
            throw e;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("게시글 삭제 중 오류가 발생했습니다.", e);
        }
    }
}
