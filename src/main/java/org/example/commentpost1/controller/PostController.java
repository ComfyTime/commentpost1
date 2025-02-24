package org.example.commentpost1.controller;

import lombok.RequiredArgsConstructor;
import org.example.commentpost1.dto.PostRequestDto;
import org.example.commentpost1.dto.PostResponseDto;
import org.example.commentpost1.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/posts")
    public PostResponseDto save(@RequestBody PostRequestDto dto) {
        return postService.save(dto);
    }

    @PutMapping("/posts/{postId}")
    public PostResponseDto update(@PathVariable Long postId, @RequestBody PostRequestDto dto) {
        return postService.update(postId, dto);
    }

    @GetMapping("posts")
    public List<PostResponseDto> getAll() {
        return postService.findAll();
    }
}
