package com.task.RestAPIServer.repository;

import com.task.RestAPIServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// 이 인터페이스가 Repository의 역할을 한다는 것을 나타냄
@Repository

// Post: 이 Repository가 관리할 Entity의 타입
// Long: Post Entity의 기본키인 id 필드의 타입
public interface PostRepository extends JpaRepository<Post, Long> {

    // 아래의 기본 메소드 사용 가능
    // save(post): 게시글 저장
    // findById(id): id로 게시글 조회
    // findAll(): 전체 게시글 조회
    // delete(post): 게시글 삭제
    // exitstById(id): id에 해당하는 게시글의 존재 여부 확인

    // title 값과 content 값이 모두 일치하는 Post가 있는지 확인
    // 존재하면 true, 존재하지 않으면 false 반환
    boolean existsByTitleAndContent(String title, String content);
}
