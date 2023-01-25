package com.shiva.manishi.exception;


import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalTime;


@ControllerAdvice
public class UserAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomError> handleAllExceptions(Exception ex, WebRequest req) {
		CustomError error = new CustomError(ex.getMessage(), LocalTime.now(), req.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {

		// custom error message
		StringBuilder sb = new StringBuilder("Total errors:" + ex.getErrorCount());

		int i = 0;
		for (FieldError fieldError : ex.getFieldErrors())
			sb.append(". Error-").append(++i).append(":").append(fieldError.getField()).append(fieldError.getDefaultMessage());

		CustomError error = new CustomError(sb.toString(), LocalTime.now(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<CustomError> handleNoUserFoundException(Exception ex, WebRequest request) {
		CustomError error = new CustomError(ex.getMessage(), LocalTime.now(), request.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(DuplicateUsernameException.class)
	public ResponseEntity<CustomError> handleDuplicateUsernameException(Exception ex, WebRequest req) {
		CustomError error = new CustomError(ex.getMessage(), LocalTime.now(), req.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


	//@ExceptionHandler()
}
