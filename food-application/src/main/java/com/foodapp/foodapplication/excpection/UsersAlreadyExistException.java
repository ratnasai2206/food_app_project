package com.foodapp.foodapplication.excpection;



public class UsersAlreadyExistException extends RuntimeException {

	private String message="Id is not present";
	
	public UsersAlreadyExistException() {
		
	}


	public UsersAlreadyExistException(String message) {
		this.message = message;
	}


	public String getMessage() {
		return message;
	}
}
