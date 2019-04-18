package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Review;


@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
	
	Review findByReviewId(Integer reviewId);
	
	List<Review> findByCustomerCustomerId(Integer customerId);
	
	List<Review> findByCustomer(Customer customer);
	
	List<Review> findByRating(int rating);
	
	List<Review> findByTextIgnoreCaseLike(String text);
	
	List<Review> findByProductProductID(Integer ProductID);
	
	List<Review> findByProduct(Product product);
	

}
