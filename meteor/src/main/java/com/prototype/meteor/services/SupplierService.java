package com.prototype.meteor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Supplier;


@Service
public interface SupplierService {
	Supplier save(Supplier supplier);
	Supplier update(Supplier supplier);
	Supplier delete(Supplier supplier);
	
	List<Supplier> findAll();

}
