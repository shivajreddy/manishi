package com.shiva.manishi.controller;


import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.entity.User;
import com.shiva.manishi.service.UserServiceLayer;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

	private final UserServiceLayer userService;

	public UserController(UserServiceLayer userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<UserDao> getAllUsers() {
		return userService.queryAllUsers();
	}

	@PostMapping("/sign-up")
	public UserDao createNewUser(@RequestBody @Valid User userData) {
		return userService.createNewUser(userData);
	}

	@GetMapping("/login")
	public String login() {
		return "login success";
	}

}
