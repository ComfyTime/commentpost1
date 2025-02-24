package org.example.commentpost1.dto;

import lombok.Getter;

@Getter
public class PostResponseDto {

    private final Long id;
    private final String title;

    public PostResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
