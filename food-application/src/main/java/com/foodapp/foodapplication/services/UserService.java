package com.foodapp.foodapplication.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.UserDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.dto.UserDto;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.UsersAlreadyExistException;
import com.foodapp.foodapplication.excpection.UsersNotExistException;
import com.foodapp.foodapplication.util.UserRoles;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public ResponseEntity<ResponseStructure<Users>> saveCustomer(UserDto users) {
		Users foundUser=userDao.getUserByPhoneNumber(users.getUserPhone());
		System.out.println(users.getUserPhone());
		if(foundUser==null) {
			Users user=new Users();
			user.setUserRole(UserRoles.CUSTOMER);
			user.setUserName(users.userName);
			user.setUserPhone(users.userPhone);
			Users recivedUsers=userDao.saveUser(user);
			
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(recivedUsers);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.CREATED);
		}else {
			throw new UsersAlreadyExistException("User Already Found") ;
		}
		
	}
	
	public ResponseEntity<ResponseStructure<Users>> saveStaff(UserDto user) {
		Users foundUser=userDao.getUserByPhoneNumber(user.getUserPhone());
		if(foundUser==null) {
			Users users =new Users();
			users.setUserName(user.userName);
			users.setUserPhone(user.userPhone);
			users.setUserRole(UserRoles.STAFF);
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
	
	public ResponseEntity<ResponseStructure<Users>> updateCustomer(UserDto users,int managerId,int userId){
		Users foundUser=userDao.getUser(userId);
		Users manager=userDao.getUser(managerId);
		if(foundUser!=null &&(manager.getUserRole()==UserRoles.BRANCHMANAGER||manager.getUserRole()==UserRoles.STAFF)) {
			if(users.getUserName()!=null) {
				foundUser.setUserName(users.getUserName());
			}
			if(users.getUserPhone()!=0) {
				foundUser.setUserPhone(users.getUserPhone());
			}
			
			Users updatedUser=userDao.saveUser(foundUser);
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated");
			responseStructure.setData(updatedUser);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);
			
		}else {
			throw new UsersNotExistException("User Not Found");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> updateStaff(UserDto user,int managerId,int userId){
		Users foundUser=userDao.getUser(userId);
		Users manager=userDao.getUser(managerId);
		if(foundUser!=null &&(manager.getUserRole()==UserRoles.BRANCHMANAGER)) {
			if(user.getUserName()!=null) {
				foundUser.setUserName(user.getUserName());
			}
			if(user.getUserPhone()!=0) {
				foundUser.setUserPhone(user.getUserPhone());
			}
			Users updatedUser=userDao.saveUser(foundUser);
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully updated");
			responseStructure.setData(updatedUser);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);
			
		}else {
			throw new UsersNotExistException("Staff Not Found");
		}
		
	}
	
	
	public ResponseEntity<ResponseStructure<Users>> getUsersByUserId(int userId){
		Users users=userDao.getUser(userId);
		ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
		if(users!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Users Found");
			responseStructure.setData(users);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);
		}else {
			throw new UsersNotExistException("User Not Found");
		}
	}
	
	public ResponseEntity<ResponseStructure<Users>> getUsersByPhone(long phoneNumber){
		Users users=userDao.getUserByPhoneNumber(phoneNumber);
		ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
		if(users!=null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Users Found");
			responseStructure.setData(users);
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);
		}else {
			throw new UsersNotExistException("User Not Found");
		}
	}
	
	
}
