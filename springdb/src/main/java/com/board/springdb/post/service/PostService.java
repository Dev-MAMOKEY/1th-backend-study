package com.board.springdb.post.service;

import com.board.springdb.post.dto.PostNewRequest;
import com.board.springdb.post.dto.PostResponse;
import com.board.springdb.post.dto.PostUpdateRequest;
import com.board.springdb.post.entity.Post;
import com.board.springdb.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional(readOnly = true)
@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 게시물 생성
    @Transactional
    public PostResponse newPost(PostNewRequest request){
        Post post = Post.builder().
               title(request.title()).
                content(request.content()).
                userName(request.userName()).build();
        Post savePost = postRepository.save(post);

        return PostResponse.builder().
                id(savePost.getId()).
                title(savePost.getTitle()).
                content(savePost.getContent()).
                userName(savePost.getUserName()).
                createAt(savePost.getCreateAt())
                .build();
    }

    // 게시물 갱신
    @Transactional
    public PostResponse updatePost(PostUpdateRequest request, Long id) {
        Post post = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        post.update(request.title(), request.content());
        return PostResponse.builder().
                id(post.getId()).
                title(post.getTitle()).
                content(post.getContent()).
                userName(post.getUserName()).
                createAt(post.getCreateAt()).
                build();


    }

    /*// 전체 조회
    public List<PostResponse> findAllPost() {
        List<Post> posts = postRepository.findAll();
        List<PostResponse> result = new ArrayList<>();

        for (Post post : posts) {
            PostResponse response = PostResponse.builder().
                    id(post.getId()).
                    title(post.getTitle()).
                    content(post.getContent()).
                    userName(post.getUserName()).
                    createAt(post.getCreateAt()).
                    build();
            result.add(response);
        }
        return result;
    }*/

    // 단건 조회
    public PostResponse findOnePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        return PostResponse.builder().
                id(post.getId())
                .title(post.getTitle()).
                content(post.getContent()).
                userName(post.getUserName()).
                createAt(post.getCreateAt()).
                build();

    }

    // 단건 삭제
    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        postRepository.delete(post);
    }

    //페이지 전체 조회
    public Page<PostResponse> getPostWithPaging(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return postRepository.findAll(pageable)
                    .map(post -> PostResponse.builder()
                            .id(post.getId())
                            .title(post.getTitle())
                            .content(post.getContent())
                            .userName(post.getUserName())
                            .createAt(post.getCreateAt())
                            .build() );
    }

}
