package com.shiva.manishi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class WebConfiguration {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		return http
				.httpBasic().and()
				.cors().and()

				.authorizeHttpRequests(req -> {

					req.requestMatchers("/sign-up").permitAll();
					req.requestMatchers("/login").permitAll();
					req.requestMatchers("/demo").permitAll();
					//req.requestMatchers("/users").permitAll();

					req.anyRequest().authenticated().and();
				})

				.csrf().disable()
				.build();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				// get the properties from the application.yml file

				registry
						.addMapping("/*")
						//.addMapping("/users")
						.allowedOrigins("http://localhost:5173")
						.maxAge(3600)
						//.allowedOrigins("/*")
						.allowedMethods("GET", "POST")
						.allowedHeaders("*")
						.allowCredentials(true);
			}
		};
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

