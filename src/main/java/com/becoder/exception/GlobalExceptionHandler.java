package com.becoder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	
	
	@ExceptionHandler(Exception.class)
public ResponseEntity<?>handelException(Exception e){
	
	log.error("GlobalExceptionHandler :: handelException ::",e.getMessage());
	
	return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
}
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<?>handleNullPointerException(Exception e){
		
		log.error("GlobalExceptionHandler :: handleNullPinterException ::",e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		
}
	
	
	@ExceptionHandler(ResourceNotFoundexception.class)
	public ResponseEntity<?>ResourceNotFoundException(Exception e){
		
		log.error("GlobalExceptionHandler :: ResourceNotFoundException ::",e.getMessage());
		
		return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
