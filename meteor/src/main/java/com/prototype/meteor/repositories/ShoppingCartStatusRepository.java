package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.ShoppingCart;
import com.prototype.meteor.entities.ShoppingCartStatus;


@Repository
public interface ShoppingCartStatusRepository extends JpaRepository<ShoppingCartStatus, Integer>{
	
	ShoppingCartStatus findByShoppingCartStatusCode(Integer shoppingCartStatusCode);
	
	List<ShoppingCartStatus> findByShoppingCartStatusDescriptionIgnoreCaseLike(String description);

	ShoppingCartStatus findByShoppingCart(ShoppingCart shoppingCart);
}
