package com.foodapp.foodapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;

import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.repository.ItemRepository;

public class ItemDao {

	@Autowired
	ItemRepository itemRepository;

	public Items saveItems(Items item) {

		return itemRepository.save(item);
	}

}
