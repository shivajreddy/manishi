package com.shiva.manishi.controller;

import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.entity.User;
import com.shiva.manishi.service.UserServiceLayer;
import jakarta.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

	private final UserServiceLayer userService;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	public UserController(UserServiceLayer userService) {
		this.userService = userService;
	}

	@GetMapping("/users")
	public List<UserDao> getAllUsers() {
		return userService.queryAllUsers();
	}

	@PostMapping("/sign-up")
	public UserDao createNewUser(@RequestBody @Valid User userData) {
		userData.setPassword(passwordEncoder.encode(userData.getPassword()));
		return userService.createNewUser(userData);
	}

	@GetMapping("/login")
	public String login() {
		return "login success";
	}

	@GetMapping("/users/{username}")
	public UserDao findUser(@PathVariable String username){
		return userService.findByUsername(username);
	}

}

