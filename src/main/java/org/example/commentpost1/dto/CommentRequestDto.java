package org.example.commentpost1.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {

    private Long postId;
    private String content;
}
