package com.foodapp.foodapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.foodapp.foodapplication.dao.ItemDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.ItemRepository;
import com.foodapp.foodapplication.repository.UserRepository;

public class ItemService {

	@Autowired
	ItemRepository itemRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ItemDao itemDao;

	public ResponseEntity<ResponseStructure<Items>> saveItem(Items item, int userId) {

		Items recievedItems = null;
		Optional<Users> user = userRepository.findById(userId);
		if (user.isPresent()) {
			if (user.get().getUserRole().equalsIgnoreCase("BRANCHMANGER")) {
				recievedItems = itemDao.saveItems(item);
			}
		}

		ResponseStructure<Items> response = new ResponseStructure<Items>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedItems);

		return new ResponseEntity<ResponseStructure<Items>>(response, HttpStatus.CREATED);

	}
}
