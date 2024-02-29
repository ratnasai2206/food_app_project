package com.foodapp.foodapplication.excpection;



public class UsersAlreadyExistException extends RuntimeException {

	private String message="User Already  present";
	
	public UsersAlreadyExistException() {
		
	}


	public UsersAlreadyExistException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
