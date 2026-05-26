package post.controller;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import post.dto.PostNewRequest;
import post.dto.PostResponse;
import post.dto.PostUpdateRequest;
import post.service.PostService;


import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping
    public PostResponse newPost(@RequestBody PostNewRequest requestDto) {

        return postService.newPost(requestDto);
    }

    @GetMapping
    public List<PostResponse> getAllPost(){
        return postService.findAllPost();
    }


    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable Long id){
        return postService.findIdPost(id);
    }
    @PutMapping("/{id}")
    public PostResponse updatePost(@PathVariable Long id, @RequestBody PostUpdateRequest requestDto){
        return postService.updatePost(id,requestDto);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Long id){
        postService.deletePost(id);
    }

}
