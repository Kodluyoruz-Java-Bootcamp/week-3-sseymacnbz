package medium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import medium.model.Blog;
import medium.model.BlogType;
import medium.model.User;

@Repository
public class BlogRepository {
	private static List<Blog> blogList = new ArrayList<>(); // Blogları tutan liste
	
	public void createBlog(Blog blog) {
		blogList.add(blog); // Bloglar listeye eklenir
	}
	
	public void getBlogs(User user) { // User'lara ait bloglar listelenir. Bunun için id'lerin eşleşmesi gerekir
		for(Blog blg : blogList) {
			if(blg.getUserId() == user.getId()) {
				System.out.print(blg.getType()+"->");
				System.out.println(blg.getBlogPost());
			}
		}
	}
	
	public void deleteBlog(Blog blog) {
		for(Blog blg : blogList) {
			if(blog.equals(blg)) {
				blogList.remove(blog);
				break;
			}
		}
	}
	
	public void publishBlog(Blog blog) {
		for(Blog blg : blogList) {
			if(blog.equals(blg)) {
				if(blog.getType().equals(BlogType.DRAFTED)) {
					blog.setType(BlogType.PUBLISHED);
				}
				else {
					System.out.println("Bu blog zaten yayindadir.");
				}
			}
		}
	}
}
