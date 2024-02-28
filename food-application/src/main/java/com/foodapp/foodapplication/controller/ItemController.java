package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.services.ItemService;

@RestController
@RequestMapping("/foodapp/items")
public class ItemController {
	
	@Autowired
	ItemService itemService;

	@PostMapping("/{userId}")
	public ResponseEntity<ResponseStructure<Items>> saveItem(@RequestBody Items item, @PathVariable int userId) {

		return itemService.saveItem(item, userId);

	}
}
