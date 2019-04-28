package com.prototype.meteor.entities;

import java.util.Objects;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "ProductHasCategory")
@Table(name = "producthascategory")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProductHasCategory {

	@EmbeddedId
	private ProductHasCategoryId Id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("categoryId")
	private Category category;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private Product product;
	
	private ProductHasCategory() {};
	
	public ProductHasCategory(Category category, Product product) {
		super();
		this.category = category;
		this.product = product;
		this.Id = new ProductHasCategoryId(category.getCategoryId(), product.getProductId());
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public int hashCode() {
		return Objects.hash(category, product);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if(obj == null || getClass() != obj.getClass())
			return false;
		ProductHasCategory that  = (ProductHasCategory) obj;
		
		return Objects.equals(category, that.category) && Objects.equals(product, that.product);
	}

}
