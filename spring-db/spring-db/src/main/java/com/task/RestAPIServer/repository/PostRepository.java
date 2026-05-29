package com.task.RestAPIServer.repository;

import com.task.RestAPIServer.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

    boolean existsByTitleAndContent(String title, String content);
}
