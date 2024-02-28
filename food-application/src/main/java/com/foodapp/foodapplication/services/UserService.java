package com.foodapp.foodapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.UserDao;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
}
