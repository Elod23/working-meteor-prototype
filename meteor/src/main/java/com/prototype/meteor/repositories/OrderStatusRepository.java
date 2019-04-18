package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.OrderStatus;


@Repository
public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer>{

	List<OrderStatus> findAllByStatusDescription(String description);
	
	OrderStatus findByStatusDescription(String description);
}
