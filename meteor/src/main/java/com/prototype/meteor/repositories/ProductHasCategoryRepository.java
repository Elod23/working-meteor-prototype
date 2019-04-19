package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.ProductHasCategory;


@Repository
public interface ProductHasCategoryRepository extends JpaRepository<ProductHasCategory, Integer>{
	
	ProductHasCategory findByProductProductId(Integer ProductID);
	
	ProductHasCategory findByProduct(Product Product);
	
	List<ProductHasCategory> findAllByProductProductIdGreaterThan(Integer ProductID);
	
	List<ProductHasCategory> findAllByProductProductIdLessThan(Integer ProductID);
	
	List<ProductHasCategory> findByCategoryCategoryId(Integer CategoryID);
	
	List<ProductHasCategory> findAllByCategoryCategoryIdGreaterThan(Integer CategoryID);
	
	List<ProductHasCategory> findAllByCategoryCategoryIdLessThan(Integer CategoryID);

}
