package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Product> getAllProducts() {
		return productService.getAll();
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Product createProduct(Product product) {
		return productService.save(product);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Product showProduct(@PathVariable Integer id) {
		return productService.getById(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Product deleteProduct(@PathVariable Integer id) {
		return productService.delete(productService.getById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Product updateProduct(@PathVariable Integer id, @RequestParam Product product) {
		return productService.update(id, product);
	}
	
}
