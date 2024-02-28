package com.foodapp.foodapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.UserDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.UsersAlreadyExistException;
import com.foodapp.foodapplication.excpection.UsersNotExistException;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<Users>> saveUser(Users users) {
		Users foundUser=userDao.getUserByPhoneNumber(users.getUserPhone());
		if(foundUser==null) {
			Users recivedUsers=userDao.saveUser(users);
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(recivedUsers);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new UsersAlreadyExistException("User Already Found") ;
		}
		
	}
	
//	public ResponseEntity<ResponseStructure<Users>> updateUser(Users users,int userId){
//		Users foundUser=userDao.getUser(userId);
//		if(foundUser!=null) {
//			if(users.getUserName()!=null) {
//				
//			}
//			
//		}else {
//			throw new UsersNotExistException("User Not Found");
//		}
//		
//	}
	
	
}
