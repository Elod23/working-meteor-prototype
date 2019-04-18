package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	
	Supplier findBySupplierId(Integer supplierId);
	
	List<Supplier> findByCUIIgnoreCase(String CUI);
	
	List<Supplier> findByCUIIgnoreCaseLike(String CUI);
	
	List<Supplier> findByNameIgnoreCase(String name);
	
	List<Supplier> findByNameIgnoreCaseLike(String name);
	
	List<Supplier> findBySupplierLogoURL(String url);
	
	Supplier findByProduct(Product product);
	
	Supplier findByAllProducts(List<Product> product);

	List<Product> findBySupplier(Supplier supplier);

}
