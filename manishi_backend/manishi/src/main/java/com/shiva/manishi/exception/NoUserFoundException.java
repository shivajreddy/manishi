package com.shiva.manishi.exception;

public class NoUserFoundException extends RuntimeException {
	public NoUserFoundException(String username) {
		super(username + " is not found!");
	}
}
