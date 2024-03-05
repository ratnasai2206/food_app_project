package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.foodapp.foodapplication.FoodApplication;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.repository.OrderRepository;

@SpringBootTest(classes = FoodApplication.class)
class OrderDaoTest {

	@Autowired
	private OrderRepository orderRepository;

	@Test
	void findOrderTest() {
		int orderId = 200;

		Optional<Orders> optional = orderRepository.findById(orderId);
		if (optional.isPresent()) {
			Orders order = optional.get();
			assertTrue(true);
		} else {
			assertTrue(false);
		}
	}

}
