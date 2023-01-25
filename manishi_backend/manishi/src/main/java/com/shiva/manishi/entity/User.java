package com.shiva.manishi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;


// # add getters and setters
@Entity
@Table(name = "User")
@Getter
@Setter
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	@Size(min = 4)
	@Column(unique = true)
	private String username;

	@NotNull
	@Size(min = 4)
	private String password;

	private boolean active = true;

	private String roles = "ROLE_USER";
}

