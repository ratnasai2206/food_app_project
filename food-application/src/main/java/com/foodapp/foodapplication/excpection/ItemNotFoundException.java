package com.foodapp.foodapplication.excpection;

public class ItemNotFoundException extends RuntimeException{

String message = "ID Not found";
	
	
	public String getMessage()
	{
		return message;
	}
	
	public ItemNotFoundException() {

	}

	public ItemNotFoundException(String message) {
		this.message = message;
	}
	
	
}
