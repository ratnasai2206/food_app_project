package com.foodapp.foodapplication.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	private ItemRepository itemRepository;

	public Items saveItems(Items item) {

		return itemRepository.save(item);
	}

	public List<Items> getAllItems() {
		return itemRepository.findAll();
	}

	public void deleteItems(Items items) {
		itemRepository.delete(items);
		
	}

	public Items getItemById(int itemId) {
		
		return itemRepository.findById(itemId).get();
	}
	
	public Items findByItemName(String name) {
		return itemRepository.findByItemName(name);
	}
	

}
