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
import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Product;
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
		return supplierService.findByIdThenConvert(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public SupplierDTO updateSupplier(@PathVariable Integer id, @RequestBody SupplierDTO supplier) {
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
		return supplierService.update(id, updatedSupplier);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Supplier deleteSupplier(@PathVariable Integer id) {
		return supplierService.delete(supplierService.findById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}/products", method = RequestMethod.GET)
	public List<Product> getAllProductsOfSupplier(@PathVariable Integer id){
		return supplierService.findById(id).getProducts();
	}
	
}
