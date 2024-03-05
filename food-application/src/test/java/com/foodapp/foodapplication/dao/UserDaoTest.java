package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.foodapp.foodapplication.FoodApplication;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.UserRepository;
import com.foodapp.foodapplication.util.UserRoles;

@SpringBootTest(classes = FoodApplication.class)
class UserDaoTest {

	@Autowired
	private UserRepository repository;
	@Autowired
	private UserDao userDao;
	
	@Test
	void saveUser() {
		Users users=new Users();
		users.setUserName("ratna");
		users.setUserPhone(7989350950l);
		users.setUserRole(UserRoles.CUSTOMER);
		Users saveUser=userDao.saveUser(users);
		
		assertEquals(users.getUserPhone(),saveUser.getUserPhone());
	}
	
	@Test
	void getUserByPhoneNumber() {
		Users users=userDao.getUserByPhoneNumber(7989350950l);
		
		assertEquals(users.getUserName(),repository.findByPhoneNumber(7989350950l).getUserName());
	}
	
	@Test
	void getUser() {
		Users user=userDao.getUser(1);
		assertEquals(user.getUserPhone(), repository.findById(1).get().getUserPhone());
		
	}

}
