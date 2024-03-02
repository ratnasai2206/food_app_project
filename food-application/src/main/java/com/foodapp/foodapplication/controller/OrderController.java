package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.OrderDto;
import com.foodapp.foodapplication.dto.OrderRequest;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.services.OrderService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/foodapp/order")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Operation(description = "Specified customer id's order is stored into DB", summary = "Place food order")
	@ApiResponses(value = { @ApiResponse(description = "Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })
	@PostMapping("/customer")
	public ResponseEntity<ResponseStructure<OrderDto>> placeOrder(@RequestBody OrderRequest request) {
		return orderService.placeOrder(request);
	}

	@Operation(description = "Specified customer id's order is retrived from DB", summary = "Display placed order")
	@ApiResponses(value = { @ApiResponse(description = "OK", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "404") })
	@GetMapping("/{orderId}")
	public ResponseEntity<ResponseStructure<OrderDto>> findById(@PathVariable int orderId) {
		return orderService.findById(orderId);
	}

	@Operation(summary = "Cancel placed order", description = "Specified customer id's order is removed from DB")
	@ApiResponses(value = { @ApiResponse(description = "Ok", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "404") })
	@DeleteMapping("/{orderId}")
	public ResponseEntity<ResponseStructure<String>> removeById(@PathVariable int orderId) {
		return orderService.removeById(orderId);
	}

}
