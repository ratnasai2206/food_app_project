package com.foodapp.foodapplication.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.UserDto;
import com.foodapp.foodapplication.entity.Users;

@RestController
@RequestMapping("/api/v1")
public class UserController2 {
	@PostMapping("/save")
	public String saveUser(@RequestBody UserDto users) {
		System.err.println(users);
		return "hi";
	}

}
