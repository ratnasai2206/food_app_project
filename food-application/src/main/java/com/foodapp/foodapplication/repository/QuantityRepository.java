package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.foodapplication.entity.Quantity;

public interface QuantityRepository extends JpaRepository<Quantity, Integer>{

}
