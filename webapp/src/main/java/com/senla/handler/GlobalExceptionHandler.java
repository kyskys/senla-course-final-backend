package com.senla.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.NoResultException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(NoResultException.class)
	public void handleNoResultException() {
		System.out.println("message1");
	}
	
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@ExceptionHandler(NullPointerException.class)
	public void handleNullPointerException() {
		System.out.println("message2");
	}
	
}
