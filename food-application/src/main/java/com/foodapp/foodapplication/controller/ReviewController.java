package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.dto.ReviewDto;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.services.ReviewService;


@RestController
public class ReviewController {
	
	@Autowired
	private ReviewService reviewservice;
	
	
	//save Review
	@PostMapping("/foodapp/Reviews/{userId}/{orderId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@PathVariable int userId, @PathVariable
			int orderId,@RequestBody ReviewDto review)
	{
		return reviewservice.saveReview(userId,orderId,review);
	}
	
	//Delete Review
	@DeleteMapping("/foodapp/Reviews/{managerId}")
	public ResponseEntity<ResponseStructure<String>> deleteReview(@PathVariable int managerId)
	{
		return reviewservice.deleteReview(managerId);
	}
	

}
