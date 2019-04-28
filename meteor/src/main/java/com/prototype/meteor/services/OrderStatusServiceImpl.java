package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.OrderStatus;
import com.prototype.meteor.repositories.OrderStatusRepository;

@Service
public class OrderStatusServiceImpl implements OrderStatusService{

	@Autowired
	private OrderStatusRepository orderStatusRepository;
	
	@Override
	public OrderStatus findById(Integer id) {
		return orderStatusRepository.getOne(id);
	}

	@Override
	public OrderStatus save(OrderStatus orderStatus) {
		return orderStatusRepository.save(orderStatus);
	}

	@Override
	public OrderStatus delete(OrderStatus orderStatus) {
		orderStatusRepository.delete(orderStatus);
		return orderStatus;
	}

	@Override
	public OrderStatus update(Integer id, OrderStatus orderStatus) {
		if (orderStatus == null) {
			return null;
		}
		OrderStatus orderStatusFromDb = orderStatusRepository.getOne(id);
		if (orderStatusFromDb == null) {
			return null;
		}
		if (orderStatus.getStatusDescription() != null) {
			orderStatusFromDb.setStatusDescription(orderStatus.getStatusDescription());
		}
		if (orderStatus.getOrdersWithStatus().size() == 0 || orderStatus.getOrdersWithStatus() == null) {
			orderStatusFromDb.getOrdersWithStatus().clear();
		}else {
			orderStatusFromDb.getOrdersWithStatus().addAll(orderStatus.getOrdersWithStatus());
		}
		
		orderStatusRepository.save(orderStatusFromDb);
		
		return orderStatus;
	}

	@Override
	public List<OrderStatus> findAll() {
		return orderStatusRepository.findAll();
	}

}
