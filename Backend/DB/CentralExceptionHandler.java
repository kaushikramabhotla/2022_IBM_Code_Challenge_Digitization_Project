package com.user.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> productExceptionHandler(UserNotFoundException excp){
		return new ResponseEntity<String>(excp.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<List<String>> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException m){
		return new ResponseEntity<List<String>>(m.getFieldErrors().stream()
				.map(FieldError::getDefaultMessage).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
	}
}