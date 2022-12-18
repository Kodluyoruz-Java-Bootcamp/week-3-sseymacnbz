package medium.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import medium.model.Blog;
import medium.model.User;
import medium.service.BlogService;

@RestController
@RequestMapping(value="/blogs")
public class BlogController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	ObjectMapper mapper;
	
	@PostMapping
	public String createUser(@RequestBody Blog blog) {
		blogService.createBlog(blog);
		return "Islem Basarili";
	}
	
	@PostMapping("/getBlogs")
	public String getBlogs(@RequestBody User user) {
		blogService.getBlogs(user);
		return "Islem Basarili";
	}
	
	@PostMapping("/deleteBlog")
	public void deleteBlog(Blog blog) {
		blogService.deleteBlog(blog);
	}
	
	@PostMapping("/publishBlog")
	public void publishBlog(Blog blog) {
		blogService.publishBlog(blog);
	}
}
