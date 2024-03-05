package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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
		item.setItemName("Burger Americano");
		item.setItemPrice(190.50);
		item.setItemType("Burger");
		item.setAvailableQuantity(300);

		assertEquals(item, items.saveItems(item));
	}

	@Test
	void testGetAllItems() {

		List<Items> itemList = itemRepository.findAll();
		assertNotNull(itemList);
	}

	
	@Test
	void testGetItemById() {

		Optional<Items> item = itemRepository.findById(302);
		assertNotNull(item.get());
	}
	
	
	@Test
	void testDeleteItem() {

		Optional<Items> item = itemRepository.findById(302);
		if (item.isPresent()) {
			Items items = item.get();
			itemRepository.delete(items);
			assertTrue(true);
		} else {
			assertTrue(false);
		}
		assertTrue(true);
	}

}
		
	
	
	
	


