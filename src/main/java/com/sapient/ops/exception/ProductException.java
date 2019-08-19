package com.sapient.ops.exception;

import org.springframework.stereotype.Component;

@Component
public class ProductException extends Exception {
private String message;
	
	public ProductException() {
		
	}

	public ProductException(String message) {
		super(message);		
	}
	
	public ProductException(String message,Exception e) {
		super(message,e);
	}
	

	@Override
	public String getMessage() {
		return this.message+"\n"+super.getMessage();
	}

	@Override
	public String toString() {
		return super.toString();
	}
}
