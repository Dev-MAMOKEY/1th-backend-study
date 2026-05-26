package post.service;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import post.dto.PostNewRequest;
import post.dto.PostResponse;
import post.dto.PostUpdateRequest;
import post.entity.Post;
import post.repository.PostRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class PostService {
    private final PostRepository postRepository;

    public PostResponse newPost(PostNewRequest request){
        Post post = Post.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .build();

        Post savePost = postRepository.save(post);

        return PostResponse.builder()
                .id(savePost.getId())
                .title(savePost.getTitle())
                .content(savePost.getContent())
                .createAt(savePost.getCreateAt())
                .build();
    }

    public List<PostResponse> findAllPost(){
        return postRepository.findAll().stream()
                .map(post -> PostResponse.builder()
                        .id(post.getId())
                        .title(post.getTitle())
                        .content(post.getContent())
                        .createAt(post.getCreateAt())
                        .build())
                        .collect(Collectors.toList());
    }

    public PostResponse findIdPost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물이 없습니다."));
        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createAt(post.getCreateAt())
                .build();
    }


    public PostResponse updatePost(Long id, PostUpdateRequest request){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물이 없습니다."));
        post.update(request.getTitle(), request.getContent());

        return PostResponse.builder()
                .id(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .createAt(post.getCreateAt())
                .build();
    }

    public void deletePost(Long id){
        Post post = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("게시물이 없습니다."));
        postRepository.delete(post);

    }










}
