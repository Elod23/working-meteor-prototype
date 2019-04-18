package com.prototype.meteor.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.ShoppingCart;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	
	List<ShoppingCart> findByCustomerID(Integer customerID);
	
	List<ShoppingCart> findByCartCreated(LocalDateTime time);
	
	List<ShoppingCart> findByCartStatusCode(Integer statusCode);
	
	List<ShoppingCart> findByCartCreatedBeforeAndCartStatusCode(LocalDateTime time, Integer statusCode);
	
	List<ShoppingCart> findByCartCreatedAfterAndCartStatusCode(LocalDateTime time, Integer statusCode);
	

}
