package com.shiva.manishi.service;

import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.entity.User;
import com.shiva.manishi.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceLayer {

	private final UserRepository userRepository;
	private final ModelMapper modelMapper = new ModelMapper();

	public UserServiceLayer(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	// Service layer operations
	public List<UserDao> queryAllUsers() {
		return userRepository.findAll().stream()
				.map(this::mapToUserDao).collect(Collectors.toList());
	}

	public UserDao findByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
		return mapToUserDao(user.get());
	}

	public UserDao createNewUser(User user) {
		User newUser = userRepository.save(user);
		return mapToUserDao(newUser);
	}


	// Mapper utility methods
	private UserDao mapToUserDao(User user) {
		return modelMapper.map(user, UserDao.class);
	}

	private User mapToUser(UserDao userDao) {
		return modelMapper.map(userDao, User.class);
	}
}
