package com.prototype.meteor.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderStatus;
import com.prototype.meteor.entities.OrderedProduct;


@Repository
public interface OrderRepository extends JpaRepository<Order,Integer>{
	
	Order findByOrderID(Integer orderId);
	
	List<Order> findByCustomer(Customer customer);
	
	List<Order> findByBillingNameIgnoreCase(String billingName);
	
	List<Order> findByDeliveryNameIgnoreCase(String deliveryName);
	
	List<Order> findByEmailIgnoreCase(String email);
	
	List<Order> findByPruchaseDate(Date date);
	
	List<Order> findByPruchaseDateAndOrderStatusStatusCode(Date date, Integer statusCode);
	
	List<Order> findByPruchaseDateBetween(Date dateStart, Date dateEnd);
	
	List<Order> findByOrderStatus(OrderStatus orderStatus);
	
	List<Order> findByBillingAddress(Address Address);
	
	Order findByAllOrderedProducts(List<OrderedProduct> orderedProducts);
	
	List<Order> findAllByOrderedProduct(OrderedProduct orderedProduct);

}
