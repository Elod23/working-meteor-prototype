package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Address;

public interface AddressService {
	Address findById(Integer id);

	List<Address> findAll();

	Address save(Address address);

	Address update(Integer id, Address address);

	Address delete(Address address);

}
