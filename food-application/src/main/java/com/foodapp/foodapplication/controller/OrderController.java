package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dao.OrderDao;
import com.foodapp.foodapplication.services.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderDao orderDao;
	
	@Autowired
	private OrderService orderService;
	
}
