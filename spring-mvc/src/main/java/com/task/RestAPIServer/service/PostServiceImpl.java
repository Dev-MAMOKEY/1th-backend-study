package com.task.RestAPIServer.service;

import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    // 게시글 생성
    @Override
    public Post save(PostRequest postRequest) {

        try {
            return postRepository.save(
                    new Post(
                            postRequest.getTitle(),
                            postRequest.getContent(),
                            LocalDateTime.now()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace(); // 로그 확인용
        }

        return null;
    }

    // 단건 게시글 조회
    @Override
    public Optional<Post> findById(Long id) {

        try {
            Optional<Post> postData = postRepository.findById(id);
            if (postData.isPresent()) {
                return postData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 전체 게시글 조회
    @Override
    public List<Post> findAllPosts() {

        try {
            List<Post> postsData = postRepository.findAll();
            if (!postsData.isEmpty()) {
                return postsData;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return List.of(); // 빈 리스트 반환
    }

    // 게시글 수정
    @Override
    public Post update(Long id, PostRequest postRequest) {

        try {
            Optional<Post> postData = postRepository.findById(id); // postData - 구데이터
            if (postData.isPresent()) {
                Post _post = postData.get(); // _post - 신데이터
                _post.setTitle(postRequest.getTitle());
                _post.setContent(postRequest.getContent());
                _post.setCreatedAt(LocalDateTime.now());
                postRepository.save(_post);
                return _post;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 게시글 삭제
    @Override
    public void delete(Long id) {

        try {
            postRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
