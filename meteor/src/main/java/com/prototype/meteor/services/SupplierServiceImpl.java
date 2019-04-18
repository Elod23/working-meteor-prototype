package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.repositories.SupplierRepository;


@Service
public class SupplierServiceImpl implements SupplierService {

	@Autowired
	private SupplierRepository supplierRepository;

	public SupplierServiceImpl(SupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier update(Supplier supplier) {
		supplierRepository.delete(supplier);
		return supplierRepository.save(supplier);
	}

	@Override
	public Supplier delete(Supplier supplier) {
		supplierRepository.delete(supplier);
		return supplier;
	}

	@Override
	public List<Supplier> findAll() {
		return supplierRepository.findAll();
	}

}
