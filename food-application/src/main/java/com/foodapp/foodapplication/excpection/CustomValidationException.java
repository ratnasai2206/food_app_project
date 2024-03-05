package com.foodapp.foodapplication.excpection;

public class CustomValidationException extends RuntimeException {

	private String message = "Input not valid";

	public CustomValidationException(String message) {
		this.message = message;
	}

	public CustomValidationException() {

	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
