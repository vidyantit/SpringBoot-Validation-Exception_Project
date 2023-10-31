package com.vid.springboot.java.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vid.springboot.java.Exception.UserNotFoundException;
import com.vid.springboot.java.Repository.UserRepository;
import com.vid.springboot.java.dto.UserRequest;
import com.vid.springboot.java.entity.User;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(UserRequest userRequest) {
		
		User users=User.build(0, userRequest.getName(), userRequest.getEmail(), 
				userRequest.getMobile(), userRequest.getGender(), userRequest.getAge(), userRequest.getNationality());
		
		return userRepository.save(users);
	}
	
	//to fetch all user
	
	public List<User> fetchAllUsers(){
		return userRepository.findAll();
	}
	
	//to return single user object
	public User getUserById(int id) throws Exception {
		User user= userRepository.findByUserId(id);
		if(user!=null) {
			return user;
		}else {
			throw new UserNotFoundException("user not foudn:"+id); 
		}
	}
	
}
