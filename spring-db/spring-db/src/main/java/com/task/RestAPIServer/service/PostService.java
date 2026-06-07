package com.task.RestAPIServer.service;

import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;
import com.task.RestAPIServer.exception.DuplicatePostException;
import com.task.RestAPIServer.exception.PostNotFoundException;
import com.task.RestAPIServer.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

// final 필드를 대상으로 생성자를 자동 생성
// postRepository를 생성자 주입 방식으로 주입받기 위해 사용
@RequiredArgsConstructor

// 이 클래스가 Service의 역할을 한다는 것을 나타냄
// Service는 Controller와 Repository 사이에서 비즈니스 로직 처리
@Service
public class PostService {

    // 게시글 데이터를 DB에 저장, 조회, 수정, 삭자하기 위한 Repository
    // final로 선언되었기 때문에 @RequiredArgsConstructor를 통해 생성자 주입
    private final PostRepository postRepository;

    // 게시글 생성
    // Controller에서 전달받은 PostRequest를 이용해 게시글을 생성하고 DB에 저장
    public Post save(PostRequest postRequest) {

        // 같은 제목과 내용의 게시글이 이미 존재하는지 확인
        if (postRepository.existsByTitleAndContent(postRequest.title(), postRequest.content())) {

            // 중복 게시글이 있으면 DuplicatePostException 예외 발생
            throw new DuplicatePostException();
        }

        // 요청 DTO에 담긴 title, content 값을 이용하여 Post Entity 객체 생성
        // id는 DB 저장 시 자동 생성됨
        Post post = new Post(postRequest.title(), postRequest.content());

        // 생성한 Post 객체를 DB에 저장
        // 저장된 Entity 객체 반환
        return postRepository.save(post);
    }

    // 단건 게시글 찾기
    public Post findById(Long id) {

        // Repository를 통해 id에 해당하는 게시글 조회
        // findById는 Optional<Post> 반환
        return postRepository.findById(id)

                // 게시글이 존재하지 않으면 PostNotFoundException 예외 발생
                .orElseThrow(() -> new PostNotFoundException(id));
    }

    // 전체 게시글 찾기
    public Page<Post> findAllPosts(Pageable pageable) {

        // Repository의 findAll(pageable)을 호출하여 페이징 처리된 게시글 목록 반환
        return postRepository.findAll(pageable);
    }

    // 게시글 수정
    public Post update(Long id, PostRequest postRequest) {

        // id에 해당하는 게시글이 존재하는지 검색
        Post post = postRepository.findById(id)

                // 존재하지 않으면 PostNotFoundException 예외 발생
                .orElseThrow(() -> new PostNotFoundException(id));

        // 요청 DTO에 담긴 title 값으로 기존 게시글의 제목 수정
        post.setTitle(postRequest.title());

        // 요청 DTO에 담긴 content 값으로 기존 게시글의 내용 수정
        post.setContent(postRequest.content());

        // 수정된 Post 객체를 DB에 다시 저장
        return postRepository.save(post);
    }

    // 게시글 삭제
    public void delete(Long id) {

        // id에 해당하는 게시글이 존재하는지 확인
        if (!postRepository.existsById(id)) {

            // 삭제하려는 게시글이 존재하지 않으면 PostNotFoundException 예외를 발생
            throw new PostNotFoundException(id);
        }

        // id에 해당하는 게시글을 DB에서 삭제
        postRepository.deleteById(id);
    }
}
