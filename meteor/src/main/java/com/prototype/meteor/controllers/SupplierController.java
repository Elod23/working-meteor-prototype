package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.domain.SupplierDTO;
import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.services.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	private SupplierService supplierService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<SupplierDTO> getAllSuppliers(){
		return supplierService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Supplier createSupplier(SupplierDTO supplier){
		return supplierService.save(supplier);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public SupplierDTO showSupplier(@PathVariable Integer id) {
		return supplierService.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Supplier updateSupplier(@RequestBody SupplierDTO supplier) {
		return supplierService.update(supplier);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Supplier deleteSupplier(@PathVariable Integer id) {
		return supplierService.delete(supplierService.findById(id));
	}
	
}
