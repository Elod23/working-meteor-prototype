package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.domain.SupplierDTO;
import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.services.SupplierService;

@RestController
@RequestMapping("/suppliers")
public class SupplierController implements BaseResource{
	
	@Autowired
	private SupplierService supplierService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity getAllSuppliers(){
		return wrapOrNotFound(supplierService.findAll());
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity createSupplier(SupplierDTO supplier){
		return wrapOrNotFound(supplierService.save(supplier));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity showSupplier(@PathVariable Integer id) {
		return wrapOrNotFound(supplierService.findByIdThenConvert(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO supplier) {
		SupplierDTO supplierDb = supplierService.findByIdThenConvert(id);
		if(supplier.getCUI() == null)
			supplier.setCUI(supplierDb.getCUI());
		if(supplier.getName() == null)
			supplier.setName(supplierDb.getName());
		if(supplier.getLogoURL() == null)
			supplier.setLogoURL(supplierDb.getLogoURL());
		
		Supplier updatedSupplier = GenericBuilder.of(Supplier::new)
									.with(Supplier::setSupplierId, id)
									.with(Supplier::setName, supplier.getName())
									.with(Supplier::setcUI, supplier.getCUI())
									.with(Supplier::setSupplierLogoURL, supplier.getLogoURL())
									.build();
		return wrapOrNotFound(supplierService.update(id, updatedSupplier));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteSupplier(@PathVariable Integer id) {
		return wrapOrNotFound(supplierService.delete(supplierService.findById(id)));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}/products", method = RequestMethod.GET)
	public ResponseEntity getAllProductsOfSupplier(@PathVariable Integer id){
		return wrapOrNotFound(supplierService.findById(id).getProducts());
	}
	
}
