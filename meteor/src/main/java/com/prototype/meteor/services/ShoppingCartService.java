package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.ShoppingCart;

public interface ShoppingCartService {
	List<ShoppingCart> findAll();
	
	ShoppingCart save(ShoppingCart shoppingCart);
	
	ShoppingCart findById(Integer id);
	
	ShoppingCart delete(ShoppingCart shoppingCart);
	
	ShoppingCart update(Integer id, ShoppingCart shoppingCart);

}
