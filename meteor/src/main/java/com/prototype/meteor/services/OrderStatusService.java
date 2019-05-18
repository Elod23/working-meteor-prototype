package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.OrderStatus;

public interface OrderStatusService {
	OrderStatus findById(Integer id);

	OrderStatus save(OrderStatus orderStatus);

	OrderStatus delete(OrderStatus orderStatus);

	OrderStatus update(Integer id, OrderStatus orderStatus);

	List<OrderStatus> findAll();

}
