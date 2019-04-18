package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.CartProduct;
import com.prototype.meteor.entities.CartProductId;
import com.prototype.meteor.entities.ShoppingCart;

@Repository
public interface CartProductsRepository extends JpaRepository<CartProduct, Integer>{
	
	CartProduct findById(CartProductId id);
	
	CartProduct findByCartProductIdCartIdAndCartProductIdProductId(Integer cartId, Integer productId);
	
	List<CartProduct> findByCartProductIdCartId(Integer cartId);
	
	List<CartProduct> findByCartProductIdProductId(Integer productId);
	
	List<CartProduct> findByCart(ShoppingCart shoppingCart);

	List<CartProduct> findByQuantity(int quantity);
	
	//<
	List<CartProduct> findByQuantityLessThan(float quantity);
	
	//>=
	List<CartProduct> findByQuantityGreaterThanEqual(float quantity);
	
	//<=
	List<CartProduct> findByQuantityLessThanEqual(float quantity);

	//>
	List<CartProduct> findByQuantityGreaterThan(float quantity);
	
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
