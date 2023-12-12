package com.example.blog.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.blog.post.Post;
import com.example.blog.post.PostRepository;

@RestController
@RequestMapping("posts")
public class PostController {
	@Autowired
	private PostRepository repository;

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping
	public void savePost(@RequestBody() Post post) {
		repository.save(post);
		return;
	}

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping
	public List<Post> getAll() {
		List<Post> postList = repository.findAll();
		return postList;
	}
	

	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
	    repository.deleteById(id);
	}

}
