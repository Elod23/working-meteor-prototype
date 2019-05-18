package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.CartProduct;
import com.prototype.meteor.repositories.CartProductsRepository;

@Service
public class CartProductServiceImpl implements CartProductService{

	@Autowired
	private CartProductsRepository cartProductsRepository;
	
	@Override
	public List<CartProduct> findAll() {
		return cartProductsRepository.findAll();
	}

	@Override
	public CartProduct findById(Integer id) {
		return cartProductsRepository.getOne(id);
	}

	@Override
	public CartProduct save(CartProduct cartProduct) {
		return cartProductsRepository.save(cartProduct);
	}

	@Override
	public CartProduct delete(CartProduct cartProduct) {
		cartProductsRepository.delete(cartProduct);
		return cartProduct;
	}

	@Override
	public CartProduct update(Integer id, CartProduct cartProduct) {
		if (cartProduct == null) {
			return null;
		}
		CartProduct cartProductFromDb = cartProductsRepository.getOne(id);
		if (cartProductFromDb == null) {
			return null;
		}
		if (cartProduct.getCart() != null) {
			cartProductFromDb.setCart(cartProduct.getCart());
		}
		if (cartProduct.getQuantity() != 0.0f) {
			cartProductFromDb.setQuantity(cartProduct.getQuantity());
		}
		if (cartProduct.getProduct() != null) {
			cartProductFromDb.setProduct(cartProduct.getProduct());
		}
		
		cartProductsRepository.save(cartProductFromDb);
		
		return cartProduct;
	}

}
