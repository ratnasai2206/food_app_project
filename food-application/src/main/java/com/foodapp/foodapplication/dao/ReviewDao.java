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
	private ReviewRepository reviewrepository;

	@Autowired
	private UserRepository userrepository;

	public Review saveReview(Review review) {
		return reviewrepository.save(review);
	}

	public String deleteReview(int managerId) {
		Optional<Users> user = userrepository.findById(managerId);
		if (user.isPresent()) {
			reviewrepository.deleteById(managerId);
			return "Review Succesfully Removed";
		} else {
			return null;
		}
	}

}
