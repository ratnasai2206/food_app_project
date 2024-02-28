package com.foodapp.foodapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.UserRepository;

@Repository
public class UserDao {

	@Autowired
	private UserRepository userRepository;
	
	public Users saveUser(Users users) {
		return userRepository.save(users);
	}
	
	public Users getUserByPhoneNumber(long phoneNumber) {
		return userRepository.findByPhoneNumber(phoneNumber);
	}
	
	public Users getUser(int userId) {
		Optional<Users> optional=userRepository.findById(userId);
		if(optional.isPresent()) {
			return optional.get();
		}else {
			return null;
		}
	}
}
