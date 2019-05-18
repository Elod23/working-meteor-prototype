package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	Category findByCategoryId(Integer categoryId);
	
	List<Category> findByName(String name);
	
	List<Category> findByNameIgnoreCase(String name);
	
	List<Category> findByNameIgnoreCaseLike(String name);
	
	List<Category> findByDescriptionIgnoreCase(String description);
	
	List<Category> findByDescriptionIgnoreCaseLike(String description);
	
	Category findByProductsInCategory(List<Product> productsInCategory);

}
