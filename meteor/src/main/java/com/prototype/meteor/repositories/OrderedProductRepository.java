package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.OrderedProduct;


@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {

	OrderedProduct findByOrderedProductId(Integer orderedProductId);
	
	List<OrderedProduct> findByNameIgnoreCase(String name);

	List<OrderedProduct> findByMeasurementUnit(String MU);

	List<OrderedProduct> findBySecondaryMU(String SMU);

	List<OrderedProduct> findByPrice(float price);

	List<OrderedProduct> findByTva(float TVA);

	List<OrderedProduct> findBydescriptionIgnoreCaseLike(String description);
	
	List<OrderedProduct> findByOrder(Order order);
	
	List<OrderedProduct> findByOrderOrderId(Integer orderId);

}
