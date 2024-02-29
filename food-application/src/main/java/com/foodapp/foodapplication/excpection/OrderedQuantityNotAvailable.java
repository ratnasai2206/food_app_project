package com.foodapp.foodapplication.excpection;


public class OrderedQuantityNotAvailable extends RuntimeException{

	private String message = "Ordered Item quantity exceeds Available quantity";

	public OrderedQuantityNotAvailable(String message) {
		this.message = message;
	}
	
	public OrderedQuantityNotAvailable() {

	}
	
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
}
