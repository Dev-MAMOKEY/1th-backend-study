package com.board.springdb.comment.repository;

import com.board.springdb.comment.entity.Comment;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
        Slice<Comment> findByPostId(Long Id, Pageable pageable);
}
