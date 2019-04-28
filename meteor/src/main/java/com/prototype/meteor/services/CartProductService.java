package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.CartProduct;

public interface CartProductService {
	
	List<CartProduct> findAll();
	
	CartProduct findById(Integer id);
	
	CartProduct save(CartProduct cartProduct);
	
	CartProduct delete(CartProduct cartProduct);
	
	CartProduct update(Integer id, CartProduct cartProduct);

}
