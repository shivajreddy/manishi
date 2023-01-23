package com.shiva.manishi.controller;


import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<UserDao> getAllUsers() {
		return userService.queryAllUsers();
	}

}
