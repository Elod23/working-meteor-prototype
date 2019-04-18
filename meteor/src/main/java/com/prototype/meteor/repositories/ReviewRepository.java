package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	List<Review> findByReviewerID(Integer reviewerID);
	
	List<Review> findByRating(int rating);
	
	List<Review> findByProductID(Integer ProductID);
	

}
