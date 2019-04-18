package com.prototype.meteor.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProductHasCategoryId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5835213864136690183L;

	@Column(name="product_id")
	private Integer productId;
	
	@Column(name="category_id")
	private Integer categoryId;
	
	private ProductHasCategoryId() {}

	public ProductHasCategoryId(Integer productId, Integer categoryId) {
		super();
		this.productId = productId;
		this.categoryId = categoryId;
	}

	@Override
	public int hashCode() {
		return Objects.hash(productId, categoryId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if(obj == null || getClass() != obj.getClass())
			return false;
		
		ProductHasCategoryId that = (ProductHasCategoryId) obj;
		return Objects.equals(productId, that.productId) && Objects.equals(categoryId, that.categoryId);
	};
	
	
}
