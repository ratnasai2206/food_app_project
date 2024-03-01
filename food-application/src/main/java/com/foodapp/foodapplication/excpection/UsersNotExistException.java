package com.foodapp.foodapplication.excpection;

public class UsersNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message="Users not present";

	public UsersNotExistException() {
		
	}

	public UsersNotExistException(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}
