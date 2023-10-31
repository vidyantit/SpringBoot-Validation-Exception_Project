package com.vid.springboot.java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vid.springboot.java.dto.UserRequest;
import com.vid.springboot.java.entity.User;
import com.vid.springboot.java.service.UserService;

import jakarta.validation.Valid;

@RequestMapping("/users")
@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUser")
    @ResponseStatus(value = HttpStatus.CREATED)
	public User saveUser(@RequestBody @Valid UserRequest userRequest) {
		return userService.saveUser(userRequest);
	}
	
	@GetMapping("/findAllUser")
	public List<User>  findAllUser(){
	return	userService.fetchAllUsers();
	}
	
	@GetMapping("/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	public User getUserById(@PathVariable int id) throws Exception {
		return userService.getUserById(id);
	}
}
