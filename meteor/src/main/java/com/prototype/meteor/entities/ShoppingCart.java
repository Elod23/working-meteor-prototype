package com.prototype.meteor.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name ="ShoppingCart")
@Table(name="shoppingcarts")
public class ShoppingCart {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shoppingcart_id")
	private Integer cartId;
	
	@OneToOne(fetch  = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@NotNull
	@Column(name = "cart_created")
	private LocalDateTime cartCreated;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shopping_cart_statuscode")
    private ShoppingCartStatus shoppingCartStatus;
	
	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<CartProduct> products = new ArrayList<>();

	// we need this constructor to ALWAYS initialize the cart with the respective
	// date to make it available and trackable
	public ShoppingCart() {
		this.cartCreated = LocalDateTime.now();
	}
	
	public ShoppingCart(LocalDateTime cartCreation) {
		this.cartCreated = cartCreation;
	}
	
	
	
	public ShoppingCartStatus getShoppingCartStatus() {
		return shoppingCartStatus;
	}

	public void setShoppingCartStatus(ShoppingCartStatus shoppingCartStatus) {
		this.shoppingCartStatus = shoppingCartStatus;
	}

	public void addProduct(CartProduct product) {
		products.add(product);
	}
	
	public void removeProduct(OrderedProduct product) {
		for(Iterator<CartProduct> iterator = products.iterator();
				iterator.hasNext();){
					CartProduct cartProduct = iterator.next();
					
					if(cartProduct.getCart().equals(this) && cartProduct.getProduct().equals(product)) {
						iterator.remove();
						cartProduct.setCart(null);
						cartProduct.setProduct(null);
					}
				}
	}

	public Integer getCartId() {
		return cartId;
	}

	public void setCartId(Integer cartId) {
		this.cartId = cartId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public List<CartProduct> getProducts() {
		return products;
	}

	public void setProducts(List<CartProduct> products) {
		this.products = products;
	}

	public LocalDateTime getCartCreated() {
		return cartCreated;
	}

	public void setCartCreated(LocalDateTime cartCreated) {
		this.cartCreated = cartCreated;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart tag = (ShoppingCart) o;
        return Objects.equals(cartCreated, tag.cartCreated);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(cartCreated);
    }

}
