package com.map.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> Exceptions()
	{
		return new ResponseEntity<String>("There is an error please try again", HttpStatus.BAD_REQUEST);
		
	}
	

}
