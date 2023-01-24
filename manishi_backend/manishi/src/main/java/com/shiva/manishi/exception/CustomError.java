package com.shiva.manishi.exception;

import java.time.LocalTime;


public class CustomError {

	private String message;
	private LocalTime timeStamp;
	private String description;

	public CustomError(String message, LocalTime timeStamp, String description) {
		this.message = message;
		this.timeStamp = timeStamp;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public LocalTime getTimeStamp() {
		return timeStamp;
	}

	public String getDescription() {
		return description;
	}
}
