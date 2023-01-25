package com.shiva.manishi.service;

import com.shiva.manishi.dao.UserDao;
import com.shiva.manishi.entity.User;
import com.shiva.manishi.exception.DuplicateUsernameException;
import com.shiva.manishi.exception.NoUserFoundException;
import com.shiva.manishi.repository.UserRepository;
import org.modelmapper.ModelMapper;
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
		user.orElseThrow(() -> new NoUserFoundException(username));
		return mapToUserDao(user.get());
	}

	public UserDao createNewUser(User user) {

		// throw appropriate error for Controller to handle errors
		Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser.isPresent()) {
			throw new DuplicateUsernameException(user.getUsername());
		}

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
