package com.foodapp.foodapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodapp.foodapplication.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer>{


}
