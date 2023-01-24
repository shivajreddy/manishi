package com.shiva.manishi;

import com.shiva.manishi.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class ManishiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManishiApplication.class, args);
	}

}
