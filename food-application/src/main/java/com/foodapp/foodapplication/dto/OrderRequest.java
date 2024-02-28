package com.foodapp.foodapplication.dto;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequest {

	private Integer userId;
	private Map<String,Integer> itemNameAndQuantity;
	private String paymentMode;
}
