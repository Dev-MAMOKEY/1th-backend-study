package com.board.springdb.comment.service;

import com.board.springdb.comment.dto.CommentRequest;
import com.board.springdb.comment.dto.CommentResponse;
import com.board.springdb.comment.entity.Comment;
import com.board.springdb.comment.repository.CommentRepository;
import com.board.springdb.post.dto.PostResponse;
import com.board.springdb.post.entity.Post;
import com.board.springdb.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    //댓글 생성
    @Transactional
    public CommentResponse newComment(Long board_id, CommentRequest request){
        Post post = postRepository.findById(board_id).orElseThrow(IllegalArgumentException::new);

        Comment comment = Comment.builder().
                commentContent(request.commentContent()).
                commentUserName(request.commentUserName()).
                post(post).
                build();
        Comment saveComment  =commentRepository.save(comment);

        return CommentResponse.builder().
                commentId(saveComment.getComment_Id()).
                commentContent(saveComment.getCommentContent()).
                commentUserName(saveComment.getCommentUserName()).
                boardId(comment.getPost().getId()).createAt(comment.getCreateAt()).build();


    }

    // 댓글 수정
    @Transactional
    public CommentResponse updateComment(Long id, Long comment_id,CommentRequest request){
        Post post =postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Comment comment = commentRepository.findById(comment_id).orElseThrow(IllegalArgumentException::new);

        if(!comment.getPost().getId().equals(id)){
            throw new IllegalArgumentException();
        }

        comment.update(request.commentContent());
        return CommentResponse.builder().
                commentId(comment.getComment_Id()).
                commentContent(comment.getCommentContent()).
                commentUserName(comment.getCommentUserName()).
                boardId(comment.getPost().getId()).
                createAt(comment.getCreateAt()).
                build();
    }

    // 댓글 단건 조회
    public CommentResponse findOneComment(Long id, Long comment_id){
        Post post =postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Comment comment = commentRepository.findById(comment_id).orElseThrow(IllegalArgumentException::new);

        if(!comment.getPost().getId().equals(id)){
            throw new IllegalArgumentException();
        }


        return CommentResponse.builder().
                commentId(comment.getComment_Id()).
                commentContent(comment.getCommentContent()).
                commentUserName(comment.getCommentUserName()).
                createAt(comment.getCreateAt()).
                boardId(comment.getPost().getId())
                .build();
    }
    // 댓글 전체 조회 -slice 적용
    public Slice<CommentResponse> getCommentWithSlice(Long boardId,int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createAt").descending());
        return commentRepository.findByPostId(boardId, pageable)
                .map(comment -> CommentResponse.builder().
                        commentId(comment.getComment_Id()).
                        commentContent(comment.getCommentContent()).
                        commentUserName(comment.getCommentUserName()).
                        boardId(comment.getPost().getId()).
                        createAt(comment.getCreateAt())
                        .build());
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long id,Long commentId){
        Post post =postRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        Comment comment = commentRepository.findById(commentId).orElseThrow(IllegalArgumentException::new);
        if(!comment.getPost().getId().equals(id)){
            throw new IllegalArgumentException();
        }

        commentRepository.delete(comment);
    }







}
