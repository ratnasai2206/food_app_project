package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.foodapp.foodapplication.FoodApplication;
import com.foodapp.foodapplication.entity.Items;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = FoodApplication.class)
class ItemDaoTest {

	@Autowired
	ItemDao items;

	@Test
	void test() {
		Items item = new Items();
		item.setItemName("Chef Shawarma Roll");
		item.setItemPrice(190.50);
		item.setItemType("Shawarma");
		item.setAvailableQuantity(300);

		assertEquals(item, items.saveItems(item));
	}

}
