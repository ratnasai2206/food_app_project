package com.foodapp.foodapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	private ItemService itemService;

	@PostMapping("/{userId}")
	public ResponseEntity<ResponseStructure<Items>> saveItem(@RequestBody Items item, @PathVariable int userId) {

		return itemService.saveItem(item, userId);

	}

	@PutMapping("/{userId}/{itemId}")
	public ResponseEntity<ResponseStructure<Items>> updateProduct(@RequestBody Items item, @PathVariable int userId,
			@PathVariable int itemId) {

		return itemService.updateItem(item, userId, itemId);

	}

	@GetMapping("/")
	public ResponseEntity<ResponseStructure<List<Items>>> getAllItems() {

		return itemService.getAllItems();

	}

	@DeleteMapping("/{userId}/{itemId}")
	public ResponseEntity<ResponseStructure<String>> deleteItem(@PathVariable int userId, @PathVariable int itemId) {

		return itemService.deleteItem(userId, itemId);

	}

	@GetMapping("/{itemId}")
	public ResponseEntity<ResponseStructure<Items>> getItemById(@PathVariable int itemId) {

		return itemService.getItemById(itemId);

	}
}
