package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.services.ReviewService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewservice;
	
	
	//save Review
	@GetMapping("/foodapp/Reviews/{userId}/{orderId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@PathVariable int userId, @PathVariable
			int orderId,@RequestBody Review review)
	{
		return reviewservice.saveReview(userId,orderId,review);
	}
	

}
