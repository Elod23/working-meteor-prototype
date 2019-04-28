package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Category;

public interface CategoryService {
	Category findById(Integer id);

	Category save(Category category);

	Category update(Integer id, Category category);

	Category delete(Category category);

	List<Category> findAll();
	

}
