package com.bridgelabs.advice;

import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeControllerAdvice {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> notAllowed(MethodArgumentNotValidException ex) {
		return new ResponseEntity<String>("Please enter valid Name", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler
	public ResponseEntity<String> notEmpty(HttpMessageNotReadableException exception) {
		return new ResponseEntity<String>("Message cant be Empty", HttpStatus.NOT_FOUND);

	}
	
	

	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> noIdPresent(NoSuchElementException exception) {
		return new ResponseEntity<String>("No id present", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<String> badReq(HttpRequestMethodNotSupportedException exception) {
		return new ResponseEntity<String>("Change HttpRequest", HttpStatus.BAD_REQUEST);
	}
}
