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

@Entity(name = "OrderedProduct")
@Table(name = "OrderedProducts")
@NaturalIdCache
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="ordered_product_id")
	private Integer OrderedProductId;

	@NotNull
	@Column(name = "name")
	@NaturalId
	private String name;

	@Column(name = "ordered_product_description")
	private String description;

	@NotNull
	@Column(name = "price")
	private float price;
	
	@NotNull
	@Column(name = "tva")
	private int TVA;

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
		return TVA;
	}

	public void setTVA(int tVA) {
		TVA = tVA;
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
		return OrderedProductId;
	}


	public void setOrderedProductId(Integer orderedProductId) {
		OrderedProductId = orderedProductId;
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
