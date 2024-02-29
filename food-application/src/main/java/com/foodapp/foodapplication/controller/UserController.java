package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.services.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/foodapp/user")
@Tag(name = "Food Application")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Operation(description = "To Create Users info",summary = "User will be saved in the database")
	@ApiResponses(value = {@ApiResponse(description = "User Created",responseCode = "201"),
						   @ApiResponse(content = @Content(),responseCode = "400" )})
	@PostMapping
	public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users user){
		return userService.saveUser(user);
	}
	
	
	@Operation(description = "To Update Users info",summary = "User Details will be updated into the database")
	@ApiResponses(value = {@ApiResponse(description = "User Updated",responseCode = "200"),
						   @ApiResponse(content = @Content(),responseCode = "400" )})
	@PutMapping("/{managerId}/{userId}")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@RequestBody Users user,@PathVariable int managerId,@PathVariable int userId) {
		return userService.updateUser(null, managerId, userId);
	}
	
	
	
	@Operation(description = "To by user by user phone number",summary = "User will be get from the database")
	@ApiResponses(value = {@ApiResponse(description = "User found",responseCode = "200"),
						   @ApiResponse(content = @Content(),responseCode = "400" )})
	@GetMapping("/phone/{phoneNumber}")
	public ResponseEntity<ResponseStructure<Users>> getUsersByPhone(@PathVariable long phoneNumber){
		return userService.getUsersByPhone(phoneNumber);
	}
	
	
	
	@Operation(description = "To by user by userId",summary = "User will be get from the database")
	@ApiResponses(value = {@ApiResponse(description = "User found",responseCode = "200"),
						   @ApiResponse(content = @Content(),responseCode = "400" )})
	@GetMapping("/userId/{userId}")
	public ResponseEntity<ResponseStructure<Users>> getUsersById(@PathVariable int userId) {
		return userService.getUsersByUserId(userId);
	}
	
}
