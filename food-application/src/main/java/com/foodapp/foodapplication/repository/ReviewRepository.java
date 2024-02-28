package com.foodapp.foodapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodapp.foodapplication.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer>{

}
