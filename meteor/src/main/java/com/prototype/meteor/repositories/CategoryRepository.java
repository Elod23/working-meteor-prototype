package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{
	
	List<Category> findByName(String name);
	
	List<Category> findByDescriptionIgnoreCase(String description);

}
