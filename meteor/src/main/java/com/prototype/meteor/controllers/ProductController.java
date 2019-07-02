package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.entities.Product;
import com.prototype.meteor.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductController implements BaseResource{

	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity getAllProducts() {
		return wrapOrNotFound(productService.getAll());
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity createProduct(Product product) {
		return wrapOrNotFound(productService.save(product));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity showProduct(@PathVariable Integer id) {
		return wrapOrNotFound(productService.getById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteProduct(@PathVariable Integer id) {
		return wrapOrNotFound(productService.delete(productService.getById(id)));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Product product) {
		return wrapOrNotFound(productService.update(id, product));
	}
	
}
