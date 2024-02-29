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
import com.foodapp.foodapplication.dto.OrderDto;
import com.foodapp.foodapplication.dto.OrderRequest;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.entity.Quantity;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.ItemNotFoundException;
import com.foodapp.foodapplication.excpection.OrderedQuantityNotAvailable;
import com.foodapp.foodapplication.excpection.UsersNotExistException;
import com.foodapp.foodapplication.util.OrderStatus;

@Service
public class OrderService {

	@Autowired
	private QuantityRepository quantityRepository;
	
	@Autowired
	private OrderDao orderDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private ItemDao itemDao;

	public ResponseEntity<ResponseStructure<OrderDto>> placeOrder(OrderRequest request){
		Orders order = new Orders();
		Users user = userDao.getUser(request.getUserId());
		
		if(user!=null) {
			//OrderRequest will contain a map of item name and its respective quantity
			Map<String, Integer> itemNameAndQuantity = request.getItemNameAndQuantity();
			Map<Items,Quantity> itemAndQuantity = new LinkedHashMap<Items, Quantity>();
			int totalQuantity = 0;
			double totalAmount = 0;
			for (Map.Entry<String, Integer> entry : itemNameAndQuantity.entrySet()) {
				String itemName = entry.getKey();
				Integer quantity = entry.getValue();
				
				//using OrderRequest's map of item name , find all the items as item names are unique
				Items item = itemDao.findByItemName(itemName);
				
				
				if(item.isAvailable()) {				
					if(item.getAvailableQuantity()>=quantity) {
						//add each items price to get total amount
						totalAmount += item.getItemPrice();
						Quantity quantityObj = new Quantity();
						quantityObj.setQuantity(quantity);
						itemAndQuantity.put(item, quantityObj);
						
						quantityRepository.save(quantityObj);
						
						//reduce and set the available quantity of the item and merge 
						int reducedItemQuantiy = item.getAvailableQuantity()-quantity;
						item.setAvailableQuantity(reducedItemQuantiy);
						
						//if the reduced item quantity turns out to be zero change the isAvailable to false
						if(reducedItemQuantiy==0) {
							item.setAvailable(false);
						}
						itemDao.saveItems(item);
						
						//add the total quantity 
						totalQuantity+=quantity;
					}
					else 
						throw new OrderedQuantityNotAvailable();
				}
				else 
					throw new OrderedQuantityNotAvailable("Item Not Available");
					
				
			}
			
			order.setStatus(OrderStatus.COMFIRMED);
			order.setPaymentMode(request.getPaymentMode());
			order.setItemQuantity(itemAndQuantity);
			order.setTotalAmount(totalAmount);
			order.setTotalQuantity(totalQuantity);
			order.setUser(user);
			
			orderDao.placeOrder(order);
			
			//for customized response ,use OrderDto
			Map<String,Quantity> itemWithNameAndQuantity = new LinkedHashMap<String, Quantity>();
			for (Map.Entry<Items, Quantity> entry : itemAndQuantity.entrySet()) {
				String itemName = entry.getKey().getItemName();
				Quantity quantity = entry.getValue();
				
				itemWithNameAndQuantity.put(itemName, quantity);	
			}
			OrderDto dto = new OrderDto();
			dto.setItemQuantity(itemWithNameAndQuantity);
			dto.setPaymentMode(request.getPaymentMode());
			dto.setStatus(OrderStatus.COMFIRMED);
			dto.setTotalAmount(totalAmount);
			dto.setTotalQuantity(totalQuantity);
			
			ResponseStructure<OrderDto> structure = new ResponseStructure<OrderDto>();
			structure.setStatusCode(HttpStatus.CREATED.value());
			structure.setMessage("Success");
			structure.setData(dto);
			
			return new ResponseEntity<ResponseStructure<OrderDto>>(structure,HttpStatus.CREATED);
		}
		else {
			throw new UsersNotExistException();
		}
		
	}

	public ResponseEntity<ResponseStructure<Orders>> findById(int orderId) {
		Orders order = orderDao.findById(orderId);
		
		if(order!=null) {
			ResponseStructure<Orders> structure = new ResponseStructure<Orders>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("OK");
			structure.setData(order);
			
			return new ResponseEntity<ResponseStructure<Orders>>(structure,HttpStatus.OK);
		}
		else
			throw new ItemNotFoundException("Order Not Found");
	}

	public ResponseEntity<ResponseStructure<String>> removeById(int orderId) {
		Orders order = orderDao.findById(orderId);
		if(order!=null) {
			orderDao.removeById(order);
			
			ResponseStructure<String> structure = new ResponseStructure<String>();
			structure.setStatusCode(HttpStatus.OK.value());
			structure.setMessage("Ok");
			structure.setData("Successfully Deleted");
			
			return new ResponseEntity<ResponseStructure<String>>(structure, HttpStatus.OK);
		}
		else
			throw new ItemNotFoundException("Order Not Found");
	}
	
	
	
	//create a method to return total price
	

}
