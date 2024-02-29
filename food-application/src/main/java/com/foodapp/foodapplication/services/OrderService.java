package com.foodapp.foodapplication.services;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.ItemDao;
import com.foodapp.foodapplication.dao.OrderDao;
import com.foodapp.foodapplication.dao.UserDao;
import com.foodapp.foodapplication.dto.OrderRequest;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.UsersNotExistException;
import com.foodapp.foodapplication.util.OrderStatus;

@Service
public class OrderService {

	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ItemDao itemDao;

	public ResponseEntity<ResponseStructure<Orders>> placeOrder(OrderRequest request){
		Orders order = new Orders();
		Users user = userDao.getUser(request.getUserId());
		
		if(user!=null) {
			//OrderRequest will contain a map of item name and its respective quantity
			Map<String, Integer> itemNameAndQuantity = request.getItemNameAndQuantity();
			Map<Items,Integer> itemAndQuantity = new LinkedHashMap<Items, Integer>();
			int totalQuantity = 0;
			double totalAmount = 0;
			for (Map.Entry<String, Integer> entry : itemNameAndQuantity.entrySet()) {
				String itemName = entry.getKey();
				Integer quantity = entry.getValue();
				
				//using OrderRequest's map of item name , find all the items as item names are unique
				Items item = itemDao.findByItemName(itemName);
				
				//add each items price to get total amount
				totalAmount += item.getItemPrice();
				itemAndQuantity.put(item, quantity);
				
				//add the total quantity 
				totalQuantity+=quantity;
			}
			
			order.setStatus(OrderStatus.COMFIRMED);
			order.setPaymentMode(request.getPaymentMode());
			order.setItemQuantity(itemAndQuantity);
			order.setTotalAmount(totalAmount);
			order.setTotalQuantity(totalQuantity);
			order.setUser(user);
			
			ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(order);
			
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new UsersNotExistException();
		}
		
	}
	
	//create a method to return total price

}
