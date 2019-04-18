package com.prototype.meteor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity(name = "ShoppingCartStatus")
@Table(name = "shoppingcartstatus")
public class ShoppingCartStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shopping_cart_statuscode")
	private Integer shoppingCartStatusCode;
	
	@NotNull
	@Column(name = "shopping_cart_status_description")
	private String shoppingCartStatusDescription;
	
	@OneToMany(mappedBy = "shoppingCartStatus",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ShoppingCart> cartsWithStatus = new ArrayList<>();

	public Integer getShoppingCartStatusId() {
		return shoppingCartStatusCode;
	}

	public void setShoppingCartStatusId(Integer shoppingCartStatusId) {
		this.shoppingCartStatusCode = shoppingCartStatusId;
	}

	public String getShoppingCartStatusDescription() {
		return shoppingCartStatusDescription;
	}

	public void setShoppingCartStatusDescription(String shoppingCartStatusDescription) {
		this.shoppingCartStatusDescription = shoppingCartStatusDescription;
	}

}
