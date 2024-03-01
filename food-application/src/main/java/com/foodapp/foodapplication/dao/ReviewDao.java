package com.foodapp.foodapplication.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.entity.Users;
import com.foodapp.foodapplication.repository.ReviewRepository;
import com.foodapp.foodapplication.repository.UserRepository;
import com.foodapp.foodapplication.util.UserRoles;

@Repository
public class ReviewDao {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private UserRepository userRepository;

	public Review saveReview(Review review) {
		return reviewRepository.save(review);
	}

	public String deleteReview(int managerId,int reviewId) {
		Optional<Users> user = userRepository.findById(managerId);
		if (user.get().getUserRole()==UserRoles.BRANCHMANAGER) {
			
			Optional<Review> optional=reviewRepository.findById(reviewId);
			if(optional.isPresent()) {
				Review review=optional.get();
				reviewRepository.delete(review);
			}
			return "Review Succesfully Removed";
		} else {
			return null;
		}
	}

	public Review findById(int reviewId) {
		
		Optional<Review> optional=reviewRepository.findById(reviewId);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	}

	
}
