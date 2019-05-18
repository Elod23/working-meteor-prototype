package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.services.CategoryService;
import com.prototype.meteor.services.ProductService;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	

	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Category createCategory(Category category) {
		return categoryService.save(category);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Category showCategory(@PathVariable Integer id) {
		return categoryService.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Category updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		return categoryService.update(id, category);
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Category deleteCategory(@PathVariable Integer id) {
		return categoryService.delete(categoryService.findById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}/products", method = RequestMethod.GET)
	public List<Product> findAllProductsInCategory(@PathVariable Integer id){
		return productService.getAllProductsByCategoryId(id);
	}
	
}
