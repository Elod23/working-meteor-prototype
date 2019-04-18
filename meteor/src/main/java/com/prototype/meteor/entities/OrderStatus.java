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

@Entity(name="OrderStatus")
@Table(name = "orderstatus")
public class OrderStatus {

	@Id
	@Column(name = "statuscode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer statusCode;
	
	@Column(name = "status_description")
	private String statusDescription;

	@OneToMany(mappedBy = "orderStatus",cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Order> ordersWithStatus = new ArrayList<>();
	
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public List<Order> getOrdersWithStatus() {
		return ordersWithStatus;
	}

	public void setOrdersWithStatus(List<Order> ordersWithStatus) {
		this.ordersWithStatus = ordersWithStatus;
	}

}
