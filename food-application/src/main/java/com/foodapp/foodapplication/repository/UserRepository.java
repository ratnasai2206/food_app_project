package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodapp.foodapplication.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT u FROM Users u WHERE u.userPhone = :userPhone")
	Users findByPhoneNumber(long userPhone);
	
}
