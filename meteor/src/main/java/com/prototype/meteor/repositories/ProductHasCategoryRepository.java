package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.ProductHasCategory;


@Repository
public interface ProductHasCategoryRepository extends JpaRepository<ProductHasCategory, Integer>{
	
	ProductHasCategory findByProductID(Integer ProductID);
	
	List<ProductHasCategory> findAllByProductIDGreaterThan(Integer ProductID);
	
	List<ProductHasCategory> findAllByProductIDLesserThan(Integer ProductID);
	
	List<ProductHasCategory> findByCategoryID(Integer CategoryID);
	
	List<ProductHasCategory> findAllByCategoryIDGreaterThan(Integer CategoryID);
	
	List<ProductHasCategory> findAllByCategoryIDLesserThan(Integer CategoryID);

}
