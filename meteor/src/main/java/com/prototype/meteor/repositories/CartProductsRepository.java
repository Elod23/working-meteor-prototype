package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.CartProduct;
import com.prototype.meteor.entities.CartProductId;
import com.prototype.meteor.entities.OrderedProduct;
import com.prototype.meteor.entities.ShoppingCart;

@Repository
public interface CartProductsRepository extends JpaRepository<CartProduct, Integer>{
	
	CartProduct findById(CartProductId id);
	
	CartProduct findByIdCartIdAndIdProductId(Integer cartId, Integer productId);
	
	List<CartProduct> findByIdCartId(Integer cartId);
	
	List<CartProduct> findByIdProductId(Integer productId);
	
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
	List<CartProduct> findByProductAndQuantityLessThan(OrderedProduct product, int quantity);
	
	//>=
	List<CartProduct> findByProductAndQuantityGreaterThanEqual(OrderedProduct product, int quantity);
		
	//<=
	List<CartProduct> findByProductAndQuantityLessThanEqual(OrderedProduct product,int quantity);

	//>
	List<CartProduct> findByProductAndQuantityGreaterThan(OrderedProduct product, int quantity);
	
}
