package com.foodapp.foodapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository repository;
	
	public Orders placeOrder(Orders order) {
		return null;
	}
}
