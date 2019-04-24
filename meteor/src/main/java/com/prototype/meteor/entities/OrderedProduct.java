package com.prototype.meteor.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.NaturalId;
import org.hibernate.annotations.NaturalIdCache;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "OrderedProduct")
@Table(name = "OrderedProducts")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ordered_product_id")
	private Integer orderedProductId;

	@NotNull
	@Column(name = "name")
	@NaturalId
	private String name;

	@Column(name = "ordered_product_description")
	private String description;

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
	@Column(name = "tva")
	private int tva;

	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public OrderedProduct(@NotNull String name) {
		super();
		this.name = name;
	}
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getTVA() {
		return tva;
	}

	public void setTVA(int tVA) {
		this.tva = tVA;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Order getOrder() {
		return order;
	}


	public void setOrder(Order order) {
		this.order = order;
	}


	public Integer getOrderedProductId() {
		return orderedProductId;
	}


	public void setOrderedProductId(Integer orderedProductId) {
		this.orderedProductId = orderedProductId;
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


	public int getTva() {
		return tva;
	}


	public void setTva(int tva) {
		this.tva = tva;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		OrderedProduct post = (OrderedProduct) o;
		return Objects.equals(name, post.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

}
