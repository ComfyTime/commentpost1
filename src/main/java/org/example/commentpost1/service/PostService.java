package org.example.commentpost1.service;

import lombok.RequiredArgsConstructor;
import org.example.commentpost1.dto.PostRequestDto;
import org.example.commentpost1.dto.PostResponseDto;
import org.example.commentpost1.entity.Comment;
import org.example.commentpost1.entity.Post;
import org.example.commentpost1.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto save(PostRequestDto dto) {
        Post post = new Post(dto.getTitle());
        Post savedPost = postRepository.save(post);
        return new PostResponseDto(savedPost.getId(), savedPost.getTitle());
    }

    @Transactional
    public PostResponseDto update(Long postId, PostRequestDto dto) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new IllegalStateException("해당 post 없음")
        );
        post.update(dto.getTitle());
        return new PostResponseDto(post.getId(), post.getTitle());
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> findAll() {
        List<Post> posts = postRepository.findAll();

        List<PostResponseDto> dtos = new ArrayList<>();
        for (Post post : posts) {
            dtos.add(new PostResponseDto(post.getId(), post.getTitle()));
        }
        return dtos;
    }
//remove
//    public void deleteById(Long postId) {
//        postRepository.deleteById(postId);
//    }

    //orphanRemoval
    @Transactional
    public void test() {
        Post post = postRepository.findById(1L).orElseThrow(
                () -> new IllegalStateException("존재 않음")
        );
        List<Comment> comments = post.getComments();
        comments.remove(0);//코멘츠를 포스트에서 분리
    }
}
