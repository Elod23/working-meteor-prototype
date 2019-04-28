package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Order;

public interface AddressService {
	Address findById(Integer id);
	
	List<Address> findAll();
	
	Address save(Address address);
	
	Address update(Integer id, Address address);
	
	Address delete(Address address);
	
	List<Order> findOrdersBillingToAddress(Address address);

}
