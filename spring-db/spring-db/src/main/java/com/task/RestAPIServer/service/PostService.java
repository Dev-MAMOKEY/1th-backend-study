package com.task.RestAPIServer.service;

import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.entity.Post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PostService {

    public Post save(PostRequest postRequest);
    public Post findById(Long id); // null일 경우 Optional이 처리
    public Page<Post> findAllPosts(Pageable pageable);
    public Post update(Long id, PostRequest postRequest);
    public void delete(Long id);
}