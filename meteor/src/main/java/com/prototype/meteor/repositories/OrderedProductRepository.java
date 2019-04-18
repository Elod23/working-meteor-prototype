package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.OrderedProduct;


@Repository
public interface OrderedProductRepository extends JpaRepository<OrderedProduct, Integer> {

	List<OrderedProduct> findByNameIgnoreCase(String name);

	List<OrderedProduct> findByMeasurementUnit(String MU);

	List<OrderedProduct> findBySecondaryMeasurementUnit(String SMU);

	List<OrderedProduct> findByPrice(float price);

	List<OrderedProduct> findByCantitateStoc(float quantity);

	List<OrderedProduct> findByQuantityLessThan(float quantity);

	List<OrderedProduct> findByQuantityLessThanEqual(float quantity);

	List<OrderedProduct> findByQuantityGreaterThan(float quantity);

	List<OrderedProduct> findByQuantityGreaterThanEqual(float quantity);

	List<OrderedProduct> findByCotaTVA(float TVA);

	List<OrderedProduct> findByOrderID(float supplierID);

	List<OrderedProduct> findBydescription(String description);

	List<OrderedProduct> findByProductID(Integer productID);

}
