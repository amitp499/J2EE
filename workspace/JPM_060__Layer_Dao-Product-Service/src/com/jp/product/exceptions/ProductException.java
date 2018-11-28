package com.jp.product.exceptions;

public class ProductException extends Exception {
	
	
	public ProductException(String message, Throwable cause) {
		super(message, cause);
		
	}

	public ProductException(String message) {
		super(message);
		
	}

}
