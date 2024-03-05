package com.foodapp.foodapplication.excpection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
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
