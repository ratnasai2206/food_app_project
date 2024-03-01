package com.foodapp.foodapplication.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.ItemDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.ItemNotFoundException;
import com.foodapp.foodapplication.excpection.UsersNotExistException;
import com.foodapp.foodapplication.repository.ItemRepository;
import com.foodapp.foodapplication.repository.UserRepository;
import com.foodapp.foodapplication.util.UserRoles;
@Service
public class ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ItemDao itemDao;

	//Performs save operation and returns Item created Response
	public ResponseEntity<ResponseStructure<Items>> saveItem(Items item, int userId) {

		Items recievedItems = null;
		Optional<Users> user = userRepository.findById(userId);
		if (user.isPresent()) {
			if (user.get().getUserRole() == UserRoles.BRANCHMANAGER) {
				item.setAvailable(true);
				recievedItems = itemDao.saveItems(item);
			}
		} else {
			throw new UsersNotExistException();
		}

		ResponseStructure<Items> response = new ResponseStructure<Items>();
		response.setStatusCode(HttpStatus.CREATED.value());
		response.setMessage("Success");
		response.setData(recievedItems);

		return new ResponseEntity<ResponseStructure<Items>>(response, HttpStatus.CREATED);

	}

	//Performs update operation and returns Item updated Response
	public ResponseEntity<ResponseStructure<Items>> updateItem(Items item, int userId, int itemId) {

		Items recievedItems = null;
		Optional<Users> user = userRepository.findById(userId);
		Optional<Items> items = itemRepository.findById(itemId);
		if (user.isPresent() && items.isPresent() && user.get().getUserRole() == UserRoles.BRANCHMANAGER) {
			if (item.getItemName() != null) {
				items.get().setItemName(item.getItemName());
			}
			if (item.getItemPrice() != 0) {
				items.get().setItemPrice(item.getItemPrice());
			}
			if (item.getItemType() != null) {
				items.get().setItemType(item.getItemType());
				;
			}
			if (item.getAvailableQuantity() != 0) {
				items.get().setAvailableQuantity(item.getAvailableQuantity());
				items.get().setAvailable(true);
			}
			recievedItems = itemDao.saveItems(items.get());
		} else {
			throw new UsersNotExistException("Not Authorized to perform this operation");
	}

		ResponseStructure<Items> response = new ResponseStructure<Items>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(recievedItems);

		return new ResponseEntity<ResponseStructure<Items>>(response, HttpStatus.OK);

	}

	//Performs get operation and returns Item List fetched Response
	public ResponseEntity<ResponseStructure<List<Items>>> getAllItems() {
		List<Items> itemList = itemDao.getAllItems();

		ResponseStructure<List<Items>> response = new ResponseStructure<List<Items>>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(itemList);

		return new ResponseEntity<ResponseStructure<List<Items>>>(response, HttpStatus.OK);
	}

	//Performs delete operations returns String 
	public ResponseEntity<ResponseStructure<String>> deleteItem(int userId, int itemId) {

		Optional<Items> items = itemRepository.findById(itemId);
		if (items.isPresent()) {

			Optional<Users> user = userRepository.findById(userId);
			if (user.get() != null && (user.get().getUserRole() == UserRoles.BRANCHMANAGER)) {
				itemDao.deleteItems(items.get());

			} else {
				throw new UsersNotExistException();
			}
		} else {
			throw new ItemNotFoundException();
		}

		ResponseStructure<String> response = new ResponseStructure<String>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData("Item Removed Successfully");

		return new ResponseEntity<ResponseStructure<String>>(response, HttpStatus.OK);

	}

	//Performs get operation and returns Item fetched by ID Response
	public ResponseEntity<ResponseStructure<Items>> getItemById(int itemId) {

		Items recievedItem = null;

		Optional<Items> items = itemRepository.findById(itemId);
		if (items.isPresent()) {
			recievedItem = itemDao.getItemById(itemId);
		} else {
			throw new ItemNotFoundException();
		}

		ResponseStructure<Items> response = new ResponseStructure<Items>();
		response.setStatusCode(HttpStatus.OK.value());
		response.setMessage("Success");
		response.setData(recievedItem);

		return new ResponseEntity<ResponseStructure<Items>>(response, HttpStatus.OK);

	}

}
