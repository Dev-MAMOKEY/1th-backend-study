package post.controller;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import post.dto.PostNewRequest;
import post.dto.PostResponse;
import post.dto.PostUpdateRequest;
import post.entity.Post;
import post.service.PostService;


import java.util.List;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;


    @PostMapping
    public ResponseEntity<PostResponse> newPost(@Valid @RequestBody PostNewRequest requestDto) {

       PostResponse postResponse =  postService.newPost(requestDto);

       return ResponseEntity.status(HttpStatus.CREATED).body(postResponse); // 201 Created
    }


    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPost(){
        return ResponseEntity.ok(postService.findAllPost());
    }


    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id){
        PostResponse postResponse = postService.findIdPost(id);
        return ResponseEntity.ok(postResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PostResponse> updatePost(@Valid @PathVariable Long id, @RequestBody PostUpdateRequest requestDto){
        PostResponse postResponse = postService.updatePost(id,requestDto);
        return ResponseEntity.ok(postResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id){
        postService.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
