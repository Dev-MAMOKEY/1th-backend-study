package post.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;


public record PostUpdateRequest(
        @Size(max = 100, message = "100자만 가능합니다.")
        String title,
        @Size(max =500, message = "200자만 가능합니다")
        String content)
{}
