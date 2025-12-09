package com.becoder.exception;

import java.util.Map;

public class MyValidationException extends RuntimeException {
	
	private Map<String, Object>error;
	
	public MyValidationException(Map<String,Object>error) {
		
		super("validation failed");
		this.error=error;
	}
	
	public Map<String, Object>getErrors(){
		
		return error;
	}

}
