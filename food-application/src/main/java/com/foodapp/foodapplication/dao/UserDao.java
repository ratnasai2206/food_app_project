package com.foodapp.foodapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
}
