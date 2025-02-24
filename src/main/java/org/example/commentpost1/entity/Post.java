package org.example.commentpost1.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@RequiredArgsConstructor
public class Post {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    public Post(String title) {
        this.title = title;
    }

    public void update(String title) {
        this.title = title;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }
}
