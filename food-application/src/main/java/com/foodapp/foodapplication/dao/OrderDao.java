package com.foodapp.foodapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.repository.OrderRepository;

@Repository
public class OrderDao {

	@Autowired
	private OrderRepository repository;
	
	public Orders placeOrder(Orders order) {
		return repository.save(order);
	}
	
	public Orders findById(int orderId) {
		Optional<Orders> optional = repository.findById(orderId);
		if(optional.isPresent())
			return optional.get();
		else
			return null;
	}

	public void removeById(Orders order) {
		repository.delete(order);
	}
	
}
