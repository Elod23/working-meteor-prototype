package com.prototype.meteor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prototype.meteor.domain.SupplierDTO;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Supplier;

public interface SupplierService {
	Supplier findById(Integer id);
	
	SupplierDTO findByIdThenConvert(Integer id);
	
	Supplier save(SupplierDTO supplier);

	SupplierDTO update(Integer id, Supplier supplier);

	Supplier delete(Supplier supplier);

	List<SupplierDTO> findAll();

	List<SupplierDTO> findByExactCUI(String CUI);

	List<SupplierDTO> findByCUIIgnoreCase(String CUI);

	List<SupplierDTO> findByNameIgnoreCase(String name);

	List<SupplierDTO> findByNameIgnoreCaseLike(String name);

	SupplierDTO findByProducts(List<Product> products);
	
	Product addProductToSupplier(Product product, Supplier supplier);
}
