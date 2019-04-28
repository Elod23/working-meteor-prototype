package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderStatus;
import com.prototype.meteor.entities.OrderedProduct;
import com.prototype.meteor.repositories.OrderRepository;
@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderRepository orderRepository;
	
	@Override
	public Order findById(Integer id) {
		return orderRepository.getOne(id);
	}

	@Override
	public Order save(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public Order delete(Order order) {
		orderRepository.delete(order);
		return order;
	}

	@Override
	public OrderService update(Integer id, Order order) {
		if (order == null) {
			return null;
		}
		Order orderFromDb = orderRepository.getOne(id);
		if (orderFromDb == null) {
			return null;
		}
		
		if (order.getBillingName() != null) {
			orderFromDb.setBillingName(order.getBillingName());
		}
		if (order.getDeliveryName() != null) {
			orderFromDb.setDeliveryName(order.getDeliveryName());
		}
		if (order.getEmail() != null) {
			orderFromDb.setEmail(order.getEmail());
		}
		if (order.getPurchaseDate() != null) {
			orderFromDb.setPurchaseDate(order.getPurchaseDate());
		}
		if (order.getBillingAddress() != null) {
			orderFromDb.setBillingAddress(order.getBillingAddress());
		}
		if (order.getCustomer() != null) {
			orderFromDb.setCustomer(order.getCustomer());
		}
		if (order.getOrderStatus() != null) {
			orderFromDb.setOrderStatus(order.getOrderStatus());
		}
		if (order.getOrderedProducts().size() == 0 || order.getOrderedProducts() == null) {
			orderFromDb.getOrderedProducts().clear();
		}else {
			orderFromDb.getOrderedProducts().addAll(order.getOrderedProducts());
		}
		return null;
	}

	@Override
	public List<Order> findAll() {
		return orderRepository.findAll();
	}

	@Override
	public List<OrderedProduct> getAllProductsForOrder(Order order) {
		return order.getOrderedProducts();
	}

}
