package com.prototype.meteor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.services.ProductService;
import com.prototype.meteor.services.SupplierService;


@RestController
public class DemoController {

	@Autowired
	private ProductService productService;

	@Autowired
	private SupplierService supplierService;

	@ResponseBody
	@GetMapping("/")
	Product demoProduct() {

		Supplier supplier = GenericBuilder.of(Supplier::new).with(Supplier::setName, "Supplier1")
				.with(Supplier::setCUI, "J32/1966/12").with(Supplier::setSupplierLogoURL, "logo1").build();

		Product product = GenericBuilder.of(Product::new)
				.with(Product::setName, "Test1")
				.with(Product::setMeasurementUnit, "DB")
				.with(Product::setSecondaryMU, "kg")
				.with(Product::setCotaTVA, 19)
				.with(Product::setPrice, 1.23f)
				.with(Product::setQuantity, 14f)
				.with(Product::setProductDescription, "Test1 descrip true")
				.build();

		supplierService.save(supplier);
		return productService.save(product);

	}
}
