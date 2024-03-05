package com.foodapp.foodapplication.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodapp.foodapplication.entity.Orders;

class OrderDaoTest {

	@Autowired
	OrderDao dao;
	
	@Test
	void test() {
		
		Orders orders = new Orders();
		
	}

}
