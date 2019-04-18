package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	List<Product> findByNameIgnoreCase(String name);
	
	List<Product> findByMeasurementUnit(String MU);
	
	List<Product> findBySecondaryMU(String SMU);
	
	List<Product> findByPrice(float price);
	
	List<Product> findByNameAndPrice(String name, float price);
	
	List<Product> findByQuantity(float quantity);
	
	List<Product> findByQuantityLessThan(float quantity);

	List<Product> findByQuantityLessThanEqual(float quantity);
	
	List<Product> findByQuantityGreaterThan(float quantity);
	
	List<Product> findByQuantityGreaterThanEqual(float quantity);
	
	List<Product> findByCotaTVA(float TVA);
	
	
	List<Product> findByProductDescription(String description);
	
	@Query("select * from Products inner join Suppliers on Products.SuppllierID = Suppliers.SupplierID where (Suppliers.Name = :name)")
	List<Product> findBySupplierName(@Param("name")String name);
}
