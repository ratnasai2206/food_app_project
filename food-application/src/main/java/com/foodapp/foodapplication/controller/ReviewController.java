package com.foodapp.foodapplication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.dto.ReviewDto;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.services.ReviewService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/foodapp/reviews")
public class ReviewController {

	@Autowired
	private ReviewService reviewService;

	@Operation(description = "To Create Review Info ", summary = "Review will be saved in the database")
	@ApiResponses(value = { @ApiResponse(description = "Review Created", responseCode = "201"),
			@ApiResponse(content = @Content(), responseCode = "400") })

	@PostMapping("/{userId}/{orderId}")
	public ResponseEntity<ResponseStructure<Review>> saveReview(@PathVariable int userId, @PathVariable int orderId,
			@RequestBody ReviewDto review) {
		return reviewService.saveReview(userId, orderId, review);
	}

	@Operation(description = "To Delete Review Info ", summary = "Review will be deleted from the database")
	@ApiResponses(value = { @ApiResponse(description = "Review Deleted", responseCode = "200"),
			@ApiResponse(content = @Content(), responseCode = "404") })
	@DeleteMapping("/{managerId}/{reviewId}")
	public ResponseEntity<ResponseStructure<String>> deleteReview(@PathVariable int managerId,@PathVariable int reviewId) {
		return reviewService.deleteReview(managerId,reviewId);
	}

}
