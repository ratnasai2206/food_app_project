package com.foodapp.foodapplication.excpection;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.foodapp.foodapplication.dto.ResponseStructure;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	
	@ExceptionHandler(UsersAlreadyExistException.class)
	public ResponseEntity<ResponseStructure<String>> catchUserAlreadyExitException(UsersAlreadyExistException doesNotPresentException){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("User Already Exists in the data base");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(doesNotPresentException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);
	}
	
<<<<<<< HEAD
	
	@ExceptionHandler(EmptyOderException.class)
	public ResponseEntity<ResponseStructure<String>> catchEmptyOrderException(EmptyOderException emptyexception){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("User Order is empty");
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setData(emptyexception.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
	}
=======
	@ExceptionHandler(ItemNotFoundException.class)
	public ResponseEntity<ResponseStructure<String>> catchItemNotFoundException(ItemNotFoundException notFoundException){
		ResponseStructure<String> responseStructure=new ResponseStructure<String>();
		responseStructure.setMessage("Item Not found");
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setData(notFoundException.getMessage());
		return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.FOUND);
	}
	
>>>>>>> e45cd93dea4e9e6cefd38d4066523861a10af394



      @ExceptionHandler(IdNotFoundException.class)
     public ResponseEntity<ResponseStructure<String>> catchIdNotFound(IdNotFoundException idnotfoundexception)
  {
	ResponseStructure<String> responseStructure=new ResponseStructure<String>();
	responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
	responseStructure.setMessage("Manager Id is not present");
	responseStructure.setData(idnotfoundexception.getMessage());
	return new ResponseEntity<ResponseStructure<String>>(responseStructure,HttpStatus.NOT_FOUND);
  }
}
