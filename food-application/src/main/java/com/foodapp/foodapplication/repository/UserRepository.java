package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.foodapp.foodapplication.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	@Query("SELECT u FROM User u WHERE u.phoneNumber = :phoneNumber")
	Users findByPhoneNumber(@Param("phoneNumber") long phoneNumber);
	
}
