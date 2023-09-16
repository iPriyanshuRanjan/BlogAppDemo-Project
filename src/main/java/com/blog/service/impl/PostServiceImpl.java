package com.blog.service.impl;


import com.blog.entities.Post;
import com.blog.payload.PostDto;
import com.blog.repository.PostRepository;
import com.blog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost = postRepository.save(post);
        return mapToDto(savedPost); // Return the PostDto here
    }

    private Post mapToEntity(PostDto postDto) {
        Post post = new Post();
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setDescription(postDto.getDescription());
        return post;
    }

    private PostDto mapToDto(Post post) {
        PostDto dto = new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setContent(post.getContent());
        dto.setDescription(post.getDescription());
        return dto;
    }
}


//import com.blog.entities.Post;
//import com.blog.payload.PostDto;
//import com.blog.repository.PostRepository;
//import com.blog.service.PostService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class PostServiceImpl implements PostService {
//    @Autowired
//    public PostServiceImpl(PostRepository postRepository) {
//        this.postRepository = postRepository;
//    }
//
//    private final PostRepository postRepository;
//    @Override
//    public PostDto createPost(PostDto postDto) {
//        Post post = mapToEntity(postDto);
//        Post savedPost = postRepository.save(post);
//        PostDto dto = mapToEntity(savedPost);
//        return dto;
//    }
//    Post mapToEntity(PostDto postDto){
//        Post post = new Post();
//        post.setTitle(postDto.getTitle());
//        post.setContent(postDto.getContent());
//        post.setDescription(postDto.getDescription());
//        return post;
//    }
//    PostDto mapToDto(Post post){
//        PostDto dto = new PostDto();
//        dto.setTitle(post.getTitle());
//        dto.setContent(post.getContent());
//        dto.setDescription(post.getDescription());
//        return dto;
//}}

//public PostDto savePost(PostDto postDto){
//    Post post =postMapper.toEntity(postDto);
//    post = postRepository.save(post);
//    return postMapper.toData(post);
//}
//
//public  CommentDto saveComment(Long postId, CommentDto commentDto){
//    Post post = postRepository.findById (postId).orElseThrow(()-> new EntityNotFoundException(String.format("Post wit id %d not found", postId)));
//    Comment comment= commentMapper.toEntity(commentDto);
//    comment.setPost(post);
//    comment= commentRepository.save(comment);
//    return commentMapper.toDto(comment)

