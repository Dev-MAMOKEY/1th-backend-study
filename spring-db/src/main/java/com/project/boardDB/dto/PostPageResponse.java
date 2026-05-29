package com.project.boardDB.dto;

import java.util.List;

public record PostPageResponse(
        List<PostResponse> posts,
        int page,
        int size,
        long totalElements, // 모든 페이지에 존재하는 총 게시글 수
        int totalPages, // 페이지로 제공되는 총 페이지 수
        boolean first // 첫 번쨰 페이지인지
) {
}
