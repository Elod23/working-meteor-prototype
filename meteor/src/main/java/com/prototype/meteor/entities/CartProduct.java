package com.prototype.meteor.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.prototype.meteor.entities.OrderedProduct;

@Entity(name = "CartProduct")
@Table(name = "cartProducts")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CartProduct {

	@EmbeddedId
	private CartProductId id;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("cartId")
	private ShoppingCart cart;

	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("productId")
	private OrderedProduct product;

	@NotNull
	@Column(name = "quantity")
	private float quantity;

	public CartProduct(ShoppingCart cart, OrderedProduct product, @NotNull float quantity) {
		super();
		this.cart = cart;
		this.product = product;
		this.quantity = quantity;
		this.id = new CartProductId(cart.getCartId(), product.getOrderedProductId());
	}

	public CartProductId getId() {
		return id;
	}

	public void setId(CartProductId id) {
		this.id = id;
	}

	public ShoppingCart getCart() {
		return cart;
	}

	public void setCart(ShoppingCart cart) {
		this.cart = cart;
	}

	public OrderedProduct getProduct() {
		return product;
	}

	public void setProduct(OrderedProduct product) {
		this.product = product;
	}

	public void setQuantity(float quantity) {
		this.quantity = quantity;
	}

	public float getQuantity() {
		return quantity;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		CartProduct that = (CartProduct) o;
		return Objects.equals(cart, that.cart) && Objects.equals(product, that.product);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cart, product);
	}

}
