package com.blog.service.impl;

import com.blog.entities.Comment;
import com.blog.entities.Post;
import com.blog.payload.CommentDto;
import com.blog.repository.CommentRepository;
import com.blog.repository.PostRepository;
import com.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService {

    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    @Override
    public CommentDto createComment(long postId, CommentDto commentDto) {
        Post post = postRepository.findById((long) postId).orElseThrow(
                () -> new EntityNotFoundException("No Record Found.")
        );
        Comment comment = mapToEntity(commentDto);
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto dto = mapToDto(savedComment);
        return dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = new Comment();
        comment.setName(commentDto.getName());
        comment.setEmail(commentDto.getEmail());
        comment.setBody(commentDto.getBody());
        return comment;

    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = new CommentDto();
        dto.setId(comment.getId());
        dto.setName(comment.getName());
        dto.setEmail(comment.getEmail());
        dto.setBody(comment.getBody());
        return dto;

    }


}

