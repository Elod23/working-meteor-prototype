package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderStatus;


@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer>{

	OrderStatus findByStatusCode(Integer statusCode);
	
	List<OrderStatus> findAllByStatusDescriptionIgnoreCase(String description);
	
	List<OrderStatus> findByStatusDescriptionIgnoreCaseLike(String description);
	
	OrderStatus findByOrdersWithStatus(List<Order> orders);
}
