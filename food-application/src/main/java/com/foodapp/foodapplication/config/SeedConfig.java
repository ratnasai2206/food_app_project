package com.foodapp.foodapplication.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.UserRepository;
import com.foodapp.foodapplication.util.UserRoles;

@Configuration
public class SeedConfig implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Override
	public void run(String... args) throws Exception {
		if (repository.count() == 0) {
			Users user = new Users();
			user.setUserName("manager");
			user.setUserPhone(999999999);
			user.setUserRole(UserRoles.BRANCHMANAGER);
			repository.save(user);
		}
	}

}
