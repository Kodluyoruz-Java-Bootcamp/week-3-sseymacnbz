package medium.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import medium.model.User;
import medium.service.UserService;

import org.json.JSONArray;
import org.json.JSONObject;

@RestController
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	ObjectMapper mapper;
	
	@PostMapping
	public String createUser(@RequestBody User user) {
		System.out.println(user.getName());
		userService.createUser(user);
		return "Islem Basarili";
	}
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
	}
	
	@PostMapping(value = "/followUser")
	public String followUser(@RequestBody  String str) throws JsonMappingException, JsonProcessingException{
		
		JsonNode node = mapper.readTree(str);
		
		User user = mapper.convertValue(node.get("user"), User.class);
		User followedUser = mapper.convertValue(node.get("followedUser"), User.class);
		userService.followUser(user, followedUser);
		return "Islem basarili";
	}
	
	@PostMapping(value="/followedUsers")
	public List<User> getFollowedUsers(@RequestBody User user) {
		
		return userService.getFollowedUsers(user);
	}
	
	@PostMapping(value = "/followTag")
	public String followTag(@RequestBody  String str) throws JsonMappingException, JsonProcessingException{
		
		JsonNode node = mapper.readTree(str);
		
		User user = mapper.convertValue(node.get("user"), User.class);
		String followedTag = mapper.convertValue(node.get("followedUser"), String.class);
		userService.followTag(user, followedTag);
		return "Islem basarili";
	}
	
	@PostMapping(value="/followedTag")
	public List<User> getFollowedTags(@RequestBody User user) {
		return userService.getFollowedUsers(user);
	}
	
	
}
