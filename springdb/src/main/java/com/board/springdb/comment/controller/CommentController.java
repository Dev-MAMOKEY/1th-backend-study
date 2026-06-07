package com.board.springdb.comment.controller;

import com.board.springdb.comment.dto.CommentRequest;
import com.board.springdb.comment.dto.CommentResponse;
import com.board.springdb.comment.service.CommentService;
import com.board.springdb.global.rsdata.RsData;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;


    // 댓글 생성
    @PostMapping("/{id}/comment")
    public ResponseEntity<RsData<CommentResponse>> newComment(@RequestBody CommentRequest commentRequest, @PathVariable Long id) {
        CommentResponse commentResponse = commentService.newComment(id, commentRequest);
        RsData<CommentResponse> rsData = new RsData<>("201-1", "댓글이 등록되었습니다", commentResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    //댓글 단건 조회
    @GetMapping("/{id}/comment/{commentId}")
    public ResponseEntity<RsData<CommentResponse>> oneComment(@PathVariable Long commentId) {
        CommentResponse commentResponse = commentService.findOneComment(commentId);
        RsData<CommentResponse> rsData = new RsData<>("200-1", "해당 댓글 조회 완료되었습니다", commentResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    //댓글 수정
    @PutMapping("/{id}/comment/{commentId}")
    public ResponseEntity<RsData<CommentResponse>> updateCommet(@PathVariable Long commentId,@RequestBody CommentRequest request){
        CommentResponse commentResponse = commentService.updateComment(commentId,request);
        RsData<CommentResponse> rsData = new RsData<>("200-1","댓글이 수정되었습니다",commentResponse);
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    // 댓글 전체 조회하기(slice)
    @GetMapping("/{id}/comment")
    public ResponseEntity<RsData<Slice<CommentResponse>>> getComment(
            @PathVariable Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Slice<CommentResponse> commentResponses = commentService.getCommentWithSlice(id, page, size);
        RsData<Slice<CommentResponse>> rsData = new RsData<>("200-1", "댓글 조회가 완료되었습니다", commentResponses);
        return  ResponseEntity.status(rsData.statusCode()).body(rsData);
    }

    @DeleteMapping("/{id}/comment/{commentId}")
    public ResponseEntity<RsData<Void>> deleteComment(@PathVariable Long commentId){
        commentService.deleteComment(commentId);

        RsData<Void> rsData = new RsData<>("200-1", "댓글이 정상적으로 삭제 되었습니다");
        return ResponseEntity.status(rsData.statusCode()).body(rsData);
    }









}
