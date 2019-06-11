package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.repositories.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address findById(Integer id) {
		return addressRepository.getOne(id);
	}

	@Override
	public List<Address> findAll() {
		return addressRepository.findAll();
	}

	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}

	@Override
	public Address update(Integer id, Address address) {
		if (address == null) {
			return null;
		}
		Address addressDb = addressRepository.getOne(id);
		if (addressDb == null) {
			return null;
		}

		if (address.getCountry() != null) {
			addressDb.setCountry(address.getCountry());
		}
		if (address.getCity() != null) {
			addressDb.setCity(address.getCity());
		}
		if (address.getRegion() != null) {
			addressDb.setRegion(address.getRegion());
		}
		if (address.getStreet() != null) {
			addressDb.setStreet(address.getStreet());
		}
		if (address.getNumber() != 0) {
			addressDb.setNumber(address.getNumber());
		}
		if (address.getCustomer() != null) {
			addressDb.setCustomer(address.getCustomer());
		}

		addressRepository.save(addressDb);
		return addressDb;
	}

	@Override
	public Address delete(Address address) {
		addressRepository.delete(address);
		return address;
	}

}
