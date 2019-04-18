package com.prototype.meteor.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	List<Order> findByCustomerID(Integer customerID);
	
	List<Order> findByBillingName(String billingName);
	
	List<Order> findByDeliveryName(String deliveryName);
	
	List<Order> findByEmail(String email);
	
	List<Order> findByPruchaseDate(Date date);
	
	List<Order> findByPruchaseDateAndOrderStatusCode(Date date, Integer orderStausCode);
	
	List<Order> findByPruchaseDateBetween(Date dateStart, Date dateEnd);
	
	List<Order> findByOrderStatusCode(Integer statusCode);
	
	List<Order> findByBillingAddressID(Integer addressID);
	
	List<Order> findByDeliveryAddressID(Integer addressID);

}
