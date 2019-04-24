package com.prototype.meteor.entities;

import java.util.ArrayList;
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name="Product")
@Table(name="products")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product {

	@Id
	@Column(name = "product_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productId;
	@NotNull
	@Column(name = "name")
	@NaturalId
	private String name;
	@NotNull
	@Column(name = "measurement_unit")
	private String measurementUnit;
	@NotNull
	@Column(name = "secondary_mu")
	private String secondaryMU;
	@NotNull
	@Column(name = "price")
	private float price;
	@NotNull
	@Column(name = "cantitate_stoc")
	private float quantity;
	@NotNull
	@Column(name = "cota_tva")
	private int cotaTVA;
	@Column(name = "product_description")
	private String productDescription;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Review> reviews = new ArrayList<>();

	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public String getSecondaryMU() {
		return secondaryMU;
	}

	public void setSecondaryMU(String secondaryMU) {
		this.secondaryMU = secondaryMU;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getQuantity() {
		return quantity;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public int getCotaTVA() {
		return cotaTVA;
	}

	public void setCotaTVA(int cotaTVA) {
		this.cotaTVA = cotaTVA;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null || getClass() != obj.getClass())
			return false;
		Product that = (Product) obj;
		return Objects.equals(name, that.getName());
	}
	
	

}
