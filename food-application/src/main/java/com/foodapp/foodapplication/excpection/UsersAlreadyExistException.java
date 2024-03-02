package com.foodapp.foodapplication.excpection;



public class UsersAlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
