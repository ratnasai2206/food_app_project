package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.dto.UserDto;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/foodapp/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Operation(description = "To Create Customer info", summary = "Customer will be saved in the database")

	@ApiResponses(value = { @ApiResponse(description = "Customer Created", responseCode = "201"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@PostMapping(value = "/customer")
	public ResponseEntity<ResponseStructure<Users>> saveCustomer(@Valid @RequestBody UserDto user) {
		
		return userService.saveCustomer(user);
	}

	@PostMapping("/save")
	public String saveUser(@RequestBody Users users) {
		System.err.println(users);
		return "hi";
	}

	@Operation(description = "To Create Staff info", summary = "Staff will be saved in the database")

	@ApiResponses(value = { @ApiResponse(description = "Staff Created", responseCode = "201"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@PostMapping("/staff")
	public ResponseEntity<ResponseStructure<Users>> saveStaff(@RequestBody UserDto user) {
		return userService.saveStaff(user);
	}

	@Operation(description = "To Update Users info", summary = "User Details will be updated into the database")

	@ApiResponses(value = { @ApiResponse(description = "User Details Updated", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@PutMapping("customer/{managerId}/{userId}")
	public ResponseEntity<ResponseStructure<Users>> updateCustomer(@RequestBody UserDto user, @PathVariable int managerId,

			@PathVariable int userId) {
		return userService.updateCustomer(user, managerId, userId);
	}

	@Operation(description = "To Update Staff info", summary = "Staff Details will be updated into the database")

	@ApiResponses(value = { @ApiResponse(description = "Staff Details Updated", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@PutMapping("staff/{managerId}/{userId}")
	public ResponseEntity<ResponseStructure<Users>> updateStaff(@RequestBody UserDto user, @PathVariable int managerId,

			@PathVariable int userId) {
		return userService.updateStaff(user, managerId, userId);
	}

	@Operation(description = "To by user by user phone number", summary = "User will be get from the database")

	@ApiResponses(value = { @ApiResponse(description = "User found", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@GetMapping("/phone/{phoneNumber}")
	public ResponseEntity<ResponseStructure<Users>> getUsersByPhone(@PathVariable long phoneNumber) {
		return userService.getUsersByPhone(phoneNumber);
	}

	@Operation(description = "To by user by userId", summary = "User will be get from the database")

	@ApiResponses(value = { @ApiResponse(description = "User found", responseCode = "200"),

			@ApiResponse(content = @Content(), responseCode = "400") })

	@GetMapping("/userId/{userId}")
	public ResponseEntity<ResponseStructure<Users>> getUsersById(@PathVariable int userId) {
		return userService.getUsersByUserId(userId);
	}

}
