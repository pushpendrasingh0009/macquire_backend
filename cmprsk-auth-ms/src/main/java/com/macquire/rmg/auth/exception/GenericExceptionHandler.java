package com.macquire.rmg.auth.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GenericExceptionHandler {

	@ExceptionHandler(AuthenticationException.class)
	public final ResponseEntity<Object> handleAuthenticationException(AuthenticationException ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex) {
		return new ResponseEntity<>(ExceptionCodes.getExceptionCode(ex.getMessage()), HttpStatus.BAD_REQUEST);
	}

}