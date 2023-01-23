package com.shiva.manishi.service;

import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.entity.User;
import com.shiva.manishi.repository.UserRepository;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.List;


@Service
public class UserService {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper = new ModelMapper();

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<UserDao> queryAllUsers() {
		List<User> allUsers = userRepository.findAll();
		return allUsers.stream().map(this::mapToUserDao).toList();
	}

	// Mapper utility methods
	private UserDao mapToUserDao(User user) {
		return modelMapper.map(user, UserDao.class);
	}

	private User mapToUser(UserDao userDao) {
		return modelMapper.map(userDao, User.class);
	}
}
