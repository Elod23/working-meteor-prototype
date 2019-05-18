package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Review;

public interface ReviewService {
	Review findById(Integer id);
	
	Review save(Review review);
	
	Review delete(Review review);
	
	Review update(Integer id, Review updatedReview);
	
	List<Review> findAll();

}
