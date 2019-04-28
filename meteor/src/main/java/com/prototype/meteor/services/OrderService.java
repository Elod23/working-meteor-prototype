package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderedProduct;

public interface OrderService {
	Order findById(Integer id);

	Order save(Order order);

	Order delete(Order order);

	OrderService update(Integer id, Order order);

	List<Order> findAll();

	List<OrderedProduct> getAllProductsForOrder(Order order);

}
