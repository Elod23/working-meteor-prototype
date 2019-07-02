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

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.services.CategoryService;
import com.prototype.meteor.services.ProductService;

@RestController
@RequestMapping("/categories")
public class ProductCategoryController implements BaseResource{
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	

	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity getAllCategories() {
		return wrapOrNotFound(categoryService.findAll());
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity createCategory(Category category) {
		return wrapOrNotFound(categoryService.save(category));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity showCategory(@PathVariable Integer id) {
		return wrapOrNotFound(categoryService.findById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateCategory(@PathVariable Integer id, @RequestBody Category category) {
		return wrapOrNotFound(categoryService.update(id, category));
	}
	
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCategory(@PathVariable Integer id) {
		return wrapOrNotFound(categoryService.delete(categoryService.findById(id)));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}/products", method = RequestMethod.GET)
	public ResponseEntity findAllProductsInCategory(@PathVariable Integer id){
		return wrapOrNotFound(productService.getAllProductsByCategoryId(id));
	}
	
}
