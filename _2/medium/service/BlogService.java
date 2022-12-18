package medium.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medium.model.Blog;
import medium.model.User;
import medium.repository.BlogRepository;

@Service
public class BlogService {
	
	@Autowired
	BlogRepository blogRepository;
	
	public void createBlog(Blog blog) {
		blogRepository.createBlog(blog);
		System.out.println("Isleminiz basariyla gerceklestirildi..");
	}
	
	public void getBlogs(User user) {
		blogRepository.getBlogs(user);
	}
	
	public void deleteBlog(Blog blog) {
		blogRepository.deleteBlog(blog);
	}
	
	public void publishBlog(Blog blog) {
		blogRepository.publishBlog(blog);
	}
}
