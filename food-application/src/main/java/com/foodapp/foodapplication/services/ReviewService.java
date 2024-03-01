package com.foodapp.foodapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.ReviewDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.dto.ReviewDto;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.EmptyOrderException;
import com.foodapp.foodapplication.excpection.IdNotFoundException;
import com.foodapp.foodapplication.repository.OrderRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewdao;

	@Autowired
	private OrderRepository orderRepository;

	// save review method
	public ResponseEntity<ResponseStructure<Review>> saveReview(int userId, int orderId, ReviewDto review) {
		Optional<Orders> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			Orders orderItem = order.get();
			Users user = orderItem.getUser();

			if (user.getUserId() == userId) {
				Review reviews=new Review();
				reviews.setReviewComment(review.getReviewComment());
				reviews.setReviewRatings(review.getReviewRatings());
				reviews.setOrder(orderItem);
				orderItem.setReview(reviews);
				
				Review savedReview = reviewdao.saveReview(reviews);
				ResponseStructure<Review> responsestructure = new ResponseStructure<Review>();
				responsestructure.setStatusCode(HttpStatus.CREATED.value());
				responsestructure.setMessage("review added");
				responsestructure.setData(savedReview);
				return new ResponseEntity<ResponseStructure<Review>>(responsestructure, HttpStatus.CREATED);
			} else {
				throw new EmptyOrderException();
			}
		} else {
			throw new IdNotFoundException();
		}
	}

	// delete Review
	public ResponseEntity<ResponseStructure<String>> deleteReview(int managerId) {
		String deletedReview = reviewdao.deleteReview(managerId);
		if (deletedReview != null) {
			ResponseStructure<String> responsestructure = new ResponseStructure<String>();
			responsestructure.setStatusCode(HttpStatus.OK.value());
			responsestructure.setMessage("Review Deleted");
			responsestructure.setData("Review Deleted Successfully");
			return new ResponseEntity<ResponseStructure<String>>(responsestructure, HttpStatus.OK);
		} else {
			throw new IdNotFoundException();
		}

	}

}
