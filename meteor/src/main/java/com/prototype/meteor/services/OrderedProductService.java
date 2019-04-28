package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderedProduct;

public interface OrderedProductService {
	List<OrderedProduct> findAll();
	
	OrderedProduct findById(Integer id);
	
	OrderedProduct save(OrderedProduct orderedProduct);
	
	OrderedProduct delete(OrderedProduct orderedProduct);
	
	OrderedProduct update(Integer id, OrderedProduct orderedProduct);
	
	List<OrderedProduct> findAllProductsForOrder(Order order);

}
