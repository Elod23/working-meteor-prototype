package com.prototype.meteor.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.ProductHasCategory;


@Service
public interface ProductService {
	List<Product> findBySupplierName(String name);
	
	List<Product> getAllProductsByCategoryId(Integer categoryID);
	List<Product> getAllProductsByCategoryName(String name);
	ProductHasCategory addProductToCategory(Product product, Category category);
	Product save(Product product);
	Product update(Product product);
	Product delete(Product product);
	Product getProductByExactName(String name);
	List<Product> getAllProductsWithName(String name);
	List<Product> getProductsByPrice(float price);
}