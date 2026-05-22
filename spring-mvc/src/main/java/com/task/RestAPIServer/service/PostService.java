package com.task.RestAPIServer.service;

import com.task.RestAPIServer.dto.PostRequest;
import com.task.RestAPIServer.dto.PostResponse;
import com.task.RestAPIServer.entity.Post;

import java.util.List;
import java.util.Optional;

public interface PostService {

    public Post save(PostRequest postRequest);
    public Optional<Post> findById(Long id); // null일 경우 Optional이 처리
    public List<Post> findAllPosts();
    public Post update(Long id, PostRequest postRequest);
    public void delete(Long id);
}