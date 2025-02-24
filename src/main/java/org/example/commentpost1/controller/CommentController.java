package org.example.commentpost1.controller;

import lombok.RequiredArgsConstructor;
import org.example.commentpost1.dto.CommentRequestDto;
import org.example.commentpost1.dto.CommentResponseDto;
import org.example.commentpost1.service.CommentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comments")
    public void save(@RequestBody CommentRequestDto dto) {
        commentService.save(dto);
    }

    @GetMapping("/comments")
    public List<CommentResponseDto> getAll() {
        return commentService.findAll();
    }

    @PutMapping("/comments/{commentId}")
    public void update(@PathVariable Long commentId, @RequestBody CommentRequestDto dto) {
        commentService.update(commentId, dto);
    }
}
