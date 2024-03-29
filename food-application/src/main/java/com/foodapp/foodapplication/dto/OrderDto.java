package com.foodapp.foodapplication.dto;

import java.util.Map;

import com.foodapp.foodapplication.util.OrderStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {

	private OrderStatus status;
	private double totalAmount;
	private String paymentMode;
	
	private Map<String,Integer> itemQuantity;
	
	private int totalQuantity;
}
