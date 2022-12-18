package medium.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import medium.model.User;
import medium.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void createUser(User user) { // User create etme metodu
		userRepository.createUser(user);
		System.out.println("Kayit basariyla gerceklestirildi");
	}
	
	public void followUser(User user, User followedUser) { // User takip etmek için kullanılan metod
		userRepository.setFollowedUsers(user, followedUser);
		//user.setFollowedUsers(followedUser);
		System.out.println("Burasi"+user.toString());
		System.out.println("Burasi2=>"+userRepository.getAllUser());
	}
	
	public List<User> getFollowedUsers(User user) { // Bir user'ın takip ettiği user'ları veren metod
		System.out.println();
		System.out.println("UserService");
		return userRepository.getFollowedUser(user);
	}
	
	public void followTag(User user, String tag) { // User'ın takip ettiği tag'leri kaydeden metod
		user.getFollowedTags().add(tag);
	}
	
	public void getFollowedTags(User user) { // User'ın takip ettiği tag'leri veren metod
		userRepository.getFollowedTags(user);
	}
	
	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

}
	
	

