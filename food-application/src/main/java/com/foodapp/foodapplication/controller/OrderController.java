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

import com.foodapp.foodapplication.dao.OrderDao;
import com.foodapp.foodapplication.dto.OrderRequest;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.services.OrderService;

@RestController
@RequestMapping("/foodapp/order")
public class OrderController {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private OrderService orderService;
	

	@PostMapping
	public ResponseEntity<ResponseStructure<Orders>> placeOrder(@RequestBody OrderRequest request ) {
		return orderService.placeOrder(request);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<ResponseStructure<Orders>> findById(@PathVariable int orderId) {
		return orderService.findById(orderId);
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<ResponseStructure<String>> removeById(@PathVariable int orderId) {
			return orderService.removeById(orderId);
	}
	 
}
	
	
	
	