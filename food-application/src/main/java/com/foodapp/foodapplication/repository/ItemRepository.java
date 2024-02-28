package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.foodapplication.entity.Items;

public interface ItemRepository extends JpaRepository<Items, Integer> {

}
