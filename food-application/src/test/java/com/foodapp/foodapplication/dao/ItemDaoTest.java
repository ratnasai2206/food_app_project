package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.foodapp.foodapplication.FoodApplication;
import com.foodapp.foodapplication.entity.Items;
import com.foodapp.foodapplication.repository.ItemRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FoodApplication.class)
class ItemDaoTest {

	@Autowired
	ItemDao items;
	
	@Autowired
	ItemRepository itemRepository;

	@Test
	void testSaveItem() {
		Items item = new Items();
		item.setItemName("Chef Shawarma Roll");
		item.setItemPrice(190.50);
		item.setItemType("Shawarma");
		item.setAvailableQuantity(300);
		
		assertEquals(item, items.saveItems(item));
	}
	
	void testGetAllItems()
	{
		assertEquals(itemRepository.findAll(), items.getAllItems());
	}
	
	void testGetItemById()
	{
		assertEquals(itemRepository.findById(301), items.getItemById(301));
	}

}
