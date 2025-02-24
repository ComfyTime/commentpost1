package org.example.commentpost1.service;

import lombok.RequiredArgsConstructor;
import org.example.commentpost1.dto.CommentRequestDto;
import org.example.commentpost1.dto.CommentResponseDto;
import org.example.commentpost1.entity.Comment;
import org.example.commentpost1.entity.Post;
import org.example.commentpost1.repository.CommentRepository;
import org.example.commentpost1.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public void save(CommentRequestDto dto) {

        Post post = postRepository.findById(dto.getPostId()).orElseThrow(
                () -> new IllegalStateException("해당 포스트 없음")
        );

        Comment comment = new Comment(dto.getContent(), post);
        commentRepository.save(comment);
    }

    @Transactional(readOnly = true)
    public List<CommentResponseDto> findAll() {
        List<Comment> comments = commentRepository.findAll();

        List<CommentResponseDto> dtos = new ArrayList<>();
        for (Comment comment : comments) {
            dtos.add(new CommentResponseDto(comment.getId(), comment.getContent()));
        }
        return dtos;
    }

    @Transactional
    public void update(Long commentId, CommentRequestDto dto) {
        Comment comment = commentRepository.findById(commentId).orElseThrow(
                () -> new IllegalStateException("해당 코멘트 없음")
        );
        comment.update(dto.getContent());
    }
}
