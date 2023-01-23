package com.shiva.manishi.repository;

import com.shiva.manishi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {

	// # custom methods

}
