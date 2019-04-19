package com.prototype.meteor.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.ShoppingCart;
import com.prototype.meteor.entities.ShoppingCartStatus;


@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Integer>{
	
	ShoppingCart findByCartId(Integer cartId);
	
	ShoppingCart findByCustomerCustomerId(Integer customerID);
	
	ShoppingCart findByCustomer(Customer customer);
	
	List<ShoppingCart> findByCartCreated(LocalDateTime time);
	
	List<ShoppingCart> findByCartCreatedBetween(LocalDateTime start, LocalDateTime end);
	
	List<ShoppingCart> findByShoppingCartStatus(ShoppingCartStatus shoppingCartStatus);
	
	List<ShoppingCart> findByCartCreatedBeforeAndShoppingCartStatusShoppingCartStatusCode(LocalDateTime time, Integer statusCode);
	
	List<ShoppingCart> findByCartCreatedAfterAndShoppingCartStatusShoppingCartStatusCode(LocalDateTime time, Integer statusCode);
	
	
	ShoppingCart findByProducts(List<Product> products);

}
