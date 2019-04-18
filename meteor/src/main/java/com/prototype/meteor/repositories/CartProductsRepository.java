package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.CartProduct;

@Repository
public interface CartProductsRepository extends JpaRepository<CartProduct, Integer>{
	
	List<CartProduct> findByProductID(Integer id);

	List<CartProduct> findByQuantity(int quantity);
	
	//<
	List<CartProduct> findByQuantityLessThan(int quantity);
	
	//>=
	List<CartProduct> findByQuantityGreaterThanEqual(int quantity);
	
	//<=
	List<CartProduct> findByQuantityLessThanEqual(int quantity);

	//>
	List<CartProduct> findByQuantityGreaterThan(int quantity);
	
	//Queries on a respective product regarding quantity
	//<
	List<CartProduct> findByProductIDAndQuantityLessThan(Integer productID, int quantity);
	
	//>=
	List<CartProduct> findByProducIDAndQuantityGreaterThanEqual(Integer productID, int quantity);
		
	//<=
	List<CartProduct> findByProductIDAndQuantityLessThanEqual(Integer productID,int quantity);

	//>
	List<CartProduct> findByProductIDAndQuantityGreaterThan(Integer productID, int quantity);
	
}
