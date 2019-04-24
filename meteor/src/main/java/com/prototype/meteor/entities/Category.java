package com.prototype.meteor.entities;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Category")
@Table(name = "categories")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	@NotNull
	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String description;

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ProductHasCategory> productsInCategory = new ArrayList<>();

	public void addProduct(Product product) {
		ProductHasCategory additionalProduct = new ProductHasCategory(this, product);
		this.productsInCategory.add(additionalProduct);
	}

	public void removeProduct(Product product) {
		for (Iterator<ProductHasCategory> iterator = this.productsInCategory.iterator(); iterator.hasNext();) {
			ProductHasCategory productWithdrawal = iterator.next();

			if (productWithdrawal.getCategory().equals(this) && productWithdrawal.getProduct().equals(product)) {
				productWithdrawal.setCategory(null);
				productWithdrawal.setProduct(null);
			}
		}
	}

	public Category() {
	};

	public Category(@NotNull String name) {
		super();
		this.name = name;
	}

	public Category(@NotNull String name, String description, List<ProductHasCategory> productsInCategory) {
		super();
		this.name = name;
		this.description = description;
		this.productsInCategory = productsInCategory;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;

		if (obj == null || getClass() != obj.getClass())
			return false;

		Category category = (Category) obj;
		return Objects.equals(name, category.getName());
	}

}
