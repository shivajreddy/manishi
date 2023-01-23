package com.shiva.manishi.entity;

import jakarta.persistence.*;


// # add getters and setters
@Entity
@Table(name = "_user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;

	private String password;


}
