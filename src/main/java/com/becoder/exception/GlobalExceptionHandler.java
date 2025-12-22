package com.becoder.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {
	

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
    	
        log.error("GlobalExceptionHandler :: handleException :: {}", e.getMessage());
        
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<?> handleNullPointerException(Exception e) {
    	
        log.error("GlobalExceptionHandler :: handleNullPointerException :: {}", e.getMessage());
        
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        
    }

    @ExceptionHandler(ResourceNotFoundexception.class)
    public ResponseEntity<?> ResourceNotFoundException(Exception e) {
    	
        log.error("GlobalExceptionHandler :: ResourceNotFoundException :: {}", e.getMessage());
        
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        
        
    }

    @ExceptionHandler(MyValidationException.class)
    public ResponseEntity<?> handleValidationException(MyValidationException e) {
    	
   
        return new ResponseEntity<>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }
    
    @ExceptionHandler(ExistsDataException.class)
    public ResponseEntity<?>handleExistDataException(ExistsDataException e){
    	
		return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
    	
    }
    
    @ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<?> handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
    	
		return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}