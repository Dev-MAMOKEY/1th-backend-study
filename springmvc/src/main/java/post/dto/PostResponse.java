package post.dto;

import lombok.Builder;

import java.time.LocalDateTime;


@Builder
public record PostResponse(Long id, String title, String content, LocalDateTime createAt) {

}
