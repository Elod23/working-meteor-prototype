package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.prototype.meteor.entities.Review;
import com.prototype.meteor.repositories.ReviewRepository;

public class ReviewServiceImpl implements ReviewService{

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Override
	public Review findById(Integer id) {
		return reviewRepository.getOne(id);
	}

	@Override
	public Review save(Review review) {
		return reviewRepository.save(review);
	}

	@Override
	public Review delete(Review review) {
		reviewRepository.delete(review);
		return review;
	}

	@Override
	public Review update(Integer id, Review updatedReview) {
		if (updatedReview == null) {
			return null;
		}
		
		Review reviewFromDb = reviewRepository.getOne(id);
		
		if(reviewFromDb == null) {
			return null;
		}
		if (updatedReview.getRating()!= 0) {
			reviewFromDb.setRating(updatedReview.getRating());
		}
		if (updatedReview.getText() != null) {
			reviewFromDb.setText(updatedReview.getText());
		}
		reviewFromDb.setReviewId(id);
		reviewRepository.save(reviewFromDb);
		return updatedReview;
	}

	@Override
	public List<Review> findAll() {
		return reviewRepository.findAll();
	}

}
