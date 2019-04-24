package com.prototype.meteor.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity(name = "Address")
@Table(name = "addresses")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "address_id")
	private Integer addressId;
	@NotNull
	@Column(name = "country")
	private String country;
	@NotNull
	@Column(name = "region")
	private String region;
	@NotNull
	@Column(name = "city")
	private String city;
	@NotNull
	@Column(name = "street")
	private String street;
	@NotNull
	@Column(name = "number")
	private int number;

	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
	private Customer customer;

	@OneToMany(mappedBy = "billingAddress", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> ordersWithBillingAddress = new ArrayList<>();

	public Customer getCustomer() {
		return customer;
	}

	public List<Order> getOrdersWithBillingAddress() {
		return ordersWithBillingAddress;
	}

	public void setOrdersWithBillingAddress(List<Order> ordersWithBillingAddress) {
		this.ordersWithBillingAddress = ordersWithBillingAddress;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Integer getAddressId() {
		return addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

}
