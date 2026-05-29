package com.project.board.repository;

import com.project.board.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    // 제목 중복 확인
    boolean existsByTitle(String title);
}
