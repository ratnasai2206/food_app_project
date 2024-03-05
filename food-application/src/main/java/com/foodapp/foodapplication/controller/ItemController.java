package com.foodapp.foodapplication.controller;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/foodapp/items")
public class ItemController {

	@Autowired
	private ItemService itemService;

	@Operation(description = "To Create Item info", summary = "Item will be saved in the database")

	@ApiResponses(value = { @ApiResponse(description = "item Created", responseCode = "201"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@PostMapping("/{userId}")
	public ResponseEntity<ResponseStructure<Items>> saveItem(@Valid @RequestBody Items item, @PathVariable int userId) {

		return itemService.saveItem(item, userId);

	}

	@Operation(description = "To Update item info", summary = "Item will be updated in the database")

	@ApiResponses(value = { @ApiResponse(description = "Item Updated", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })
	@PutMapping("/{userId}/{itemId}")
	public ResponseEntity<ResponseStructure<Items>> updateProduct(@Valid @RequestBody Items item, @PathVariable int userId,
			@PathVariable int itemId, BindingResult result) {

		return itemService.updateItem(item, userId, itemId);

	}

	@Operation(description = "To get Items list", summary = "Items list will be fetched from the database")

	@ApiResponses(value = { @ApiResponse(description = "Item found", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })
	@GetMapping("/")
	public ResponseEntity<ResponseStructure<List<Items>>> getAllItems() {

		return itemService.getAllItems();

	}

	@Operation(description = "To Delete by itemId", summary = "Item will be delted from the database")

	@ApiResponses(value = { @ApiResponse(description = "User found", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@DeleteMapping("/{userId}/{itemId}")
	public ResponseEntity<ResponseStructure<String>> deleteItem(@PathVariable int userId, @PathVariable int itemId) {

		return itemService.deleteItem(userId, itemId);

	}

	@Operation(description = "To get Items by id", summary = "Items list will be fetched from the database")

	@ApiResponses(value = { @ApiResponse(description = "Item found", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@GetMapping("/{itemId}")
	public ResponseEntity<ResponseStructure<Items>> getItemById(@PathVariable int itemId) {

		return itemService.getItemById(itemId);

	}
}
