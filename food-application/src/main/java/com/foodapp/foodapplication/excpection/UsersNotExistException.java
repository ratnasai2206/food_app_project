package com.foodapp.foodapplication.excpection;

public class UsersNotExistException extends RuntimeException{

	private String message="Id is not present";

	public UsersNotExistException() {
		
	}

	public UsersNotExistException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
