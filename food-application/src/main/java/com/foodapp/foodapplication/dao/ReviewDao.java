package com.foodapp.foodapplication.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.repository.ReviewRepository;

@Repository
public class ReviewDao {
	
	@Autowired
	private ReviewRepository reviewrepository;
	
	public Review saveReview(Review review)
	{
		return reviewrepository.save(review);
	}

}
