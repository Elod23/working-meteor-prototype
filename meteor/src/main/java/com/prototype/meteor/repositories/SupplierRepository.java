package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Supplier;


@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	
	List<Supplier> findByCUIIgnoreCase(String CUI);
	
	List<Supplier> findByNameIgnoreCase(String name);
	
	List<Supplier> findBySupplierLogoURL(String url);

}
