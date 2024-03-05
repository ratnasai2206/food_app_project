package com.foodapp.foodapplication.dto;

import java.util.Map;

import org.springframework.validation.annotation.Validated;

import com.foodapp.foodapplication.util.OrderStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
public class OrderDto {

	private OrderStatus status;
	private double totalAmount;
	@NotNull(message = "provide the payment mode")
	private String paymentMode;
	
	private Map<String,Integer> itemQuantity;
	
	private int totalQuantity;
}
