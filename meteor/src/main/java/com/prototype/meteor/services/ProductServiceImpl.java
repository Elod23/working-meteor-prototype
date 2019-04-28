package com.prototype.meteor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Category;
import com.prototype.meteor.entities.Product;
import com.prototype.meteor.entities.ProductHasCategory;
import com.prototype.meteor.entities.Supplier;
import com.prototype.meteor.repositories.CategoryRepository;
import com.prototype.meteor.repositories.ProductHasCategoryRepository;
import com.prototype.meteor.repositories.ProductRepository;
import com.prototype.meteor.repositories.SupplierRepository;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private ProductHasCategoryRepository productHasCategoryRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private SupplierRepository supplierRepository;

	public ProductServiceImpl(ProductRepository productRepository,
			ProductHasCategoryRepository productHasCategoryRepository, CategoryRepository categoryRepository,
			SupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.productHasCategoryRepository = productHasCategoryRepository;
		this.categoryRepository = categoryRepository;
		this.supplierRepository = supplierRepository;
	}

	/*
	 * Possible methods giving usability regards to Category.
	 */
	@Override
	public List<Product> getAllProductsByCategoryId(Integer categoryID) {
		List<ProductHasCategory> productHasCategory = productHasCategoryRepository.findByCategoryCategoryId(categoryID);
		List<Product> productsForCategoryId = new ArrayList<>();
		for (ProductHasCategory record : productHasCategory) {
			productsForCategoryId.add(productRepository.getOne(record.getProduct().getProductId()));
		}
		return productsForCategoryId;
	}

	@Override
	public List<Product> getAllProductsByCategoryName(String name) {
		List<Product> productsByCategoryName = new ArrayList<>();
		List<Category> categories = categoryRepository.findByName(name);
		List<ProductHasCategory> records = new ArrayList<>();

		for (Category category : categories) {
			records.addAll(productHasCategoryRepository.findByCategoryCategoryId(category.getCategoryId()));
		}
		for (ProductHasCategory relation : records) {
			productsByCategoryName.add(productRepository.getOne(relation.getProduct().getProductId()));
		}
		return productsByCategoryName;
	}
	
	@Override
	public ProductHasCategory addProductToCategory(Product product, Category category) {
		ProductHasCategory record = new ProductHasCategory(category, product);
		
		return productHasCategoryRepository.save(record);
	}

	/*
	 * Basic CRUD repository methods with some optional queries for Products.
	 */
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Product update(Integer id, Product product) {
		Product changes = productRepository.getOne(id);
		
		if(product.getName() != null)
			changes.setName(product.getName());
		if(product.getMeasurementUnit() !=  null)
			changes.setMeasurementUnit(product.getMeasurementUnit());
		if(product.getSecondaryMU() !=  null)
			changes.setSecondaryMU(product.getSecondaryMU());
		if(product.getPrice() != 0.0f)
			changes.setPrice(product.getPrice());
		if(product.getQuantity() != 0.0f)
			changes.setQuantity(product.getQuantity());
		if(product.getCotaTVA() != 0)
			changes.setCotaTVA(product.getCotaTVA());
		if(product.getProductDescription() != null)
			changes.setProductDescription(product.getProductDescription());
		if(product.getReviews() != null)
			changes.getReviews().addAll(product.getReviews());
		changes.setProductId(id);
		
		return productRepository.save(changes);
	}

	@Override
	public Product delete(Product product) {
		productRepository.delete(product);
		return product;
	}

	@Override
	public Product getProductByExactName(String name) {
		List<Product> productsWithName = new ArrayList<>();
		productsWithName = productRepository.findByNameIgnoreCase(name);

		for (Product prod : productsWithName) {
			if (prod.getName().equals(name))
				return prod;
		}
		return null;
	}

	@Override
	public List<Product> getAllProductsWithName(String name) {
		return productRepository.findByNameIgnoreCase(name);
	}

	public List<Product> getAllProductsByMeasuerementUnit(String mu) {
		return productRepository.findByMeasurementUnit(mu);
	}

	public List<Product> getAllProductsBySecondaryMeasuerementUnit(String mu) {
		return productRepository.findBySecondaryMU(mu);
	}

	public List<Product> getProductsByNameAndPrice(String name, float price) {
		return productRepository.findByNameAndPrice(name, price);
	}

	@Override
	public List<Product> getProductsByPrice(float price) {
		return productRepository.findByPrice(price);
	}

	public List<Product> getProductsWithExactQuantity(float quantity) {
		return productRepository.findByQuantity(quantity);
	}

	public List<Product> getProductsWithQuantityLessThan(float quantity) {
		return productRepository.findByQuantityLessThan(quantity);
	}

	public List<Product> getProductsWithQuantityLessThanEqual(float quantity) {
		return productRepository.findByQuantityLessThanEqual(quantity);
	}

	public List<Product> getProductsWithQuantityGreaterThan(float quantity) {
		return productRepository.findByQuantityGreaterThan(quantity);
	}

	public List<Product> getProductsWithQuantityGreaterThanEqual(float quantity) {
		return productRepository.findByQuantityGreaterThanEqual(quantity);
	}

	public List<Product> findByTVA(float tva) {
		return productRepository.findByCotaTVA(tva);
	}

	public List<Product> findByDescriptionExact(String descrip) {
		return productRepository.findByProductDescription(descrip);
	}

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

	@Override
	public Product getById(Integer id) {
		return productRepository.findByProductId(id);
	}

	
	

}
