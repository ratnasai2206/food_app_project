package com.foodapp.foodapplication.dto;

import java.util.Map;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Validated
public class OrderRequest {

	private Integer userId;
	private Map<String,Integer> itemNameAndQuantity;
	@NotNull
	private String paymentMode;
}
