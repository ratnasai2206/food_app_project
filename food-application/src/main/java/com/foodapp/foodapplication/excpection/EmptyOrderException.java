package com.foodapp.foodapplication.excpection;

public class EmptyOrderException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message = "Order is empty";

	public EmptyOrderException() {

	}

	public EmptyOrderException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

}
