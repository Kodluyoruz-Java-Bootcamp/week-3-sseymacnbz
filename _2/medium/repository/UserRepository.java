package medium.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import medium.model.User;

@Repository
public class UserRepository {
	private static List<User> userList = new ArrayList<>();
	public List<User> userTempList = new ArrayList<>();
	public void createUser(User user) { // User'lar eklenir.
		userList.add(user);
	}
	
	public List<User> getFollowedUser(User user) { // Gelen user'ın takip ettiği user'lar döndürülür
		
		for(User usr : userList) {
			System.out.println("Repodaki Liste"+usr);
			if(user.equals(usr)) {
				
				userTempList = user.getFollowedUsers();
				System.out.println("Repository=>"+userTempList);
				/*for(User fu : user.getFollowedUsers()) {
					System.out.println(fu.getName());
				}*/
			}
		}
		return userTempList;
	}

	public void getFollowedTags(User user) {
		for(User usr : userList) {
			if(user.equals(usr)) {
				for(String tag : user.getFollowedTags()) {
					System.out.println(tag);
				}
			}
		}
		
	}
	
	public void setFollowedUsers(User user, User followedUser) {
		for(User usr: userList) {
			if(usr.equals(user)) {
				user.setFollowedUsers(followedUser);
			}
		}
	}
	
	public List<User> getAllUser(){
		return userList;
	}
}
