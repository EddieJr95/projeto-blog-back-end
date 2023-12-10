package com.example.blog.controller;

import com.example.blog.post.PostRequestDTO;
import com.example.blog.post.PostResponseDTO;
import com.example.blog.post.Post;
import com.example.blog.post.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("posts")
public class PostController {
    @Autowired
    private PostRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void savePost(@RequestBody PostRequestDTO data){
        Post postData = new Post(data);
        repository.save(postData);
        return;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<PostResponseDTO> getAll(){

        List<PostResponseDTO> postList =repository.findAll().stream().map(PostResponseDTO::new).toList();
        return postList;

    }

}
