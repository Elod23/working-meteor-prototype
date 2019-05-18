package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.repositories.CategoryRepository;


@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category findById(Integer id) {
		return categoryRepository.findByCategoryId(id);
	}


	public CategoryServiceImpl(CategoryRepository categoryRepository) {
		super();
		this.categoryRepository = categoryRepository;
	}

	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public Category update(Integer id, Category category) {
		Category changes = categoryRepository.getOne(id);
		
		if(category.getName() != null)
			changes.setName(category.getName());
		if(category.getDescription() != null)
			changes.setDescription(category.getDescription());
		changes.setCategoryId(id);
		
		return categoryRepository.save(changes);
	}

	@Override
	public Category delete(Category category) {
		categoryRepository.delete(category);
		return category;
	}

	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

}
