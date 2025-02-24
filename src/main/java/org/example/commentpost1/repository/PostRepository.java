package org.example.commentpost1.repository;

import org.example.commentpost1.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
