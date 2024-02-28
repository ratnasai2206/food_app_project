package com.foodapp.foodapplication.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.foodapp.foodapplication.dao.ReviewDao;
import com.foodapp.foodapplication.dto.ResponseStructure;
import com.foodapp.foodapplication.entity.Orders;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.excpection.EmptyOderException;
import com.foodapp.foodapplication.repository.OrderRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewDao reviewdao;

	@Autowired
	private OrderRepository orderRepository;

	// save  review method
	public ResponseEntity<ResponseStructure<Review>> saveReview(int userId, int orderId, Review review) {
		Optional<Orders> order = orderRepository.findById(orderId);
		if (order.isPresent()) {
			Orders orderItem = order.get();
			Users user = orderItem.getUser();

			if (user.getUserId() == userId) {
				Review savedReview=reviewdao.saveReview(review);
				ResponseStructure<Review> responsestructure = new ResponseStructure<Review>();
				responsestructure.setStatusCode(HttpStatus.CREATED.value());
				responsestructure.setMessage("review added");
				responsestructure.setData(savedReview);

			} else {
				throw new EmptyOderException();
			}
		}
		return null;
	}

}
