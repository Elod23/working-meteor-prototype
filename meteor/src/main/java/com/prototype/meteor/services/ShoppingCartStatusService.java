package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.ShoppingCart;
import com.prototype.meteor.entities.ShoppingCartStatus;

public interface ShoppingCartStatusService {
	List<ShoppingCartStatus> findAll();
	
	ShoppingCartStatus findById(Integer id);
	
	ShoppingCartStatus save(ShoppingCartStatus shoppingCartStatus);
	
	ShoppingCartStatus delete(ShoppingCartStatus shoppingCartStatus);
	
	ShoppingCartStatus update(Integer id, ShoppingCartStatus shoppingCartStatus);
	
	List<ShoppingCart> findAllCartsWithStatus(ShoppingCartStatus shoppingCartStatus);

}
