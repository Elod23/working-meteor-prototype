package com.prototype.meteor.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CartProductId implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 877813102184064602L;
	
	@Column(name="cart_id")
	private Integer cartId;
	
	@Column(name="product_id")
	private Integer productId;
	
	public CartProductId(Integer cartId, Integer productId) {
		super();
		this.cartId = cartId;
		this.productId = productId;
	};
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
 
        if (o == null || getClass() != o.getClass())
            return false;
 
        CartProductId that = (CartProductId) o;
        return Objects.equals(cartId, that.cartId) &&
               Objects.equals(productId, that.productId);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }
}
