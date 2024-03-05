package com.foodapp.foodapplication.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.foodapp.foodapplication.FoodApplication;
import com.foodapp.foodapplication.entity.Review;
import com.foodapp.foodapplication.repository.ReviewRepository;
import com.foodapp.foodapplication.repository.UserRepository;
import com.foodapp.foodapplication.util.UserRoles;

@SpringBootTest(classes = FoodApplication.class)
class ReviewDaoTest {

	@Autowired
	private ReviewDao reviewDao;

	@Autowired
	private UserDao userDao;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ReviewRepository reviewRepository;

	@Test
	void testSave() {
		Review review = new Review();

		review.setReviewComment("Very tasty");
		review.setReviewRatings(4.5);

		Review reviews = reviewDao.saveReview(review);
		assertEquals(review, reviews);
	}

	@Test
	void testDelete() {
		int reviewId = 104;
		int managerId = 2;

		if (((userRepository.findById(managerId)).get()).getUserRole() == UserRoles.BRANCHMANAGER) {
			Optional<Review> optional = reviewRepository.findById(reviewId);
			if (optional.isPresent()) {
				Review review = optional.get();
				reviewRepository.delete(review);
				assertTrue(true);
			} else {
				assertTrue(false);
			}
			assertTrue(true);
		} else {
			assertTrue(false);
		}

	}


}
