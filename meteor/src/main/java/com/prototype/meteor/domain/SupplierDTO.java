package com.prototype.meteor.domain;

import java.util.List;

import com.prototype.meteor.entities.Product;

public class SupplierDTO {
	
	private String name;
	
	private String logoURL;
	
	private String CUI;
	
	private List<Product> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public String getCUI() {
		return CUI;
	}

	public void setCUI(String cUI) {
		CUI = cUI;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	

}
