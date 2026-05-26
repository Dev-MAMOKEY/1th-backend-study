package post.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class PostUpdateRequest {
    @Size(max = 100, message = "100자만 가능합니다.")
    private String title;
    @Size(max =500, message = "200자만 가능합니다")
    private String content;
}
