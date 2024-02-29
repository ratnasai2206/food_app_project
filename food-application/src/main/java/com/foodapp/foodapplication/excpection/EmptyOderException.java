package com.foodapp.foodapplication.excpection;

public class EmptyOderException extends RuntimeException {

	private String message = "Order is empty";

	public EmptyOderException() {

	}

	public EmptyOderException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;

	}

}
