package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
}
