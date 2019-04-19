package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.domain.SupplierDTO;
import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Product;
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
	List<Product> demoProduct() {

		SupplierDTO supplier = GenericBuilder.of(SupplierDTO::new)
				.with(SupplierDTO::setName, "Supplier12")
				.with(SupplierDTO::setCUI, "J32/1966/12")
				.with(SupplierDTO::setLogoURL, "logo1")
				.build();

		

		
		
		Product product = GenericBuilder.of(Product::new)
				.with(Product::setName, "Test33")
				.with(Product::setMeasurementUnit, "DB")
				.with(Product::setSecondaryMU, "kg")
				.with(Product::setCotaTVA, 19)
				.with(Product::setPrice, 1.23f)
				.with(Product::setQuantity, 14f)
				.with(Product::setProductDescription, "Test1 descrip true")
				.build();
		
		Product product2 = GenericBuilder.of(Product::new)
				.with(Product::setName, "Test44")
				.with(Product::setMeasurementUnit, "DB")
				.with(Product::setSecondaryMU, "kg")
				.with(Product::setCotaTVA, 19)
				.with(Product::setPrice, 1.23f)
				.with(Product::setQuantity, 14f)
				.with(Product::setProductDescription, "Test1 descrip true")
				.build();
		
		Product product3 = GenericBuilder.of(Product::new)
				.with(Product::setName, "Test55")
				.with(Product::setMeasurementUnit, "DB")
				.with(Product::setSecondaryMU, "kg")
				.with(Product::setCotaTVA, 19)
				.with(Product::setPrice, 1.23f)
				.with(Product::setQuantity, 14f)
				.with(Product::setProductDescription, "Test1 descrip true")
				.build();
		
		
		
		productService.save(product);
		productService.save(product2);
		productService.save(product3);
		supplier.getProducts().add(product);
		supplier.getProducts().add(product2);
		supplier.getProducts().add(product3);
		
		
		supplierService.save(supplier);
		return supplier.getProducts();
		
		

	}
}
