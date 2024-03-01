package com.foodapp.foodapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.ReviewRepository;
import com.foodapp.foodapplication.repository.UserRepository;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}

	public String deleteReview(int managerId) {
		Optional<Users> user = userRepository.findById(managerId);
		if (user.isPresent()) {
			reviewRepository.deleteById(managerId);
			return "Review Succesfully Removed";
		} else {
			return null;
		}
	}

}
