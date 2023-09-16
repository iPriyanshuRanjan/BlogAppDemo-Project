package com.blog.controller;

import com.blog.payload.CommentDto;
import com.blog.service.CommentService;
import com.blog.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController( CommentService commentService) {

        this.commentService = commentService;
    }
   // http://localhost:8080/api/posts/1/comments
    @PostMapping("/{postId}/comments")
    public ResponseEntity<CommentDto> saveComment(
            @PathVariable Long postId,
            @RequestBody CommentDto commentDto) {

        CommentDto savedCommentDto = commentService.createComment(postId, commentDto);

        return new ResponseEntity<>(savedCommentDto,HttpStatus.CREATED);
    }
}
