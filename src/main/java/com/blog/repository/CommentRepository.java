package com.blog.repository;

import com.blog.entities.Comment;
import com.blog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    // Your repository methods
}
