package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Category;


public interface CategoryService {
	Category save(Category category);
	Category update(Category category);
	Category delete(Category category);
	
	List<Category> findAll();

}
