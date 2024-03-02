package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.foodapplication.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{


}
