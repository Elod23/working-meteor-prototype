package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.services.AddressService;

@RestController
@RequestMapping("/addresses")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public List<Address> getAll(){
		return addressService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public Address createAddress(Address address) {
		return addressService.save(address);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public Address showAddress(@PathVariable Integer id) {
		return addressService.findById(id);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Address updateAddress(@PathVariable Integer id, @RequestBody Address address) {
		Address addressDb = addressService.findById(id);
		if(addressDb == null)
			return null;
		if (address == null) {
			return null;
		}
		if (address.getCountry() != null) {
			addressDb.setCountry(address.getCountry());
		}
		if(address.getRegion() != null) {
			addressDb.setRegion(address.getRegion());
		}
		if(address.getCity() != null) {
			addressDb.setCity(address.getCity());
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
		addressDb.setAddressId(id);
		addressService.save(addressDb);
		return address;
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Address deleteAddress(@PathVariable Integer id) {
		return addressService.delete(addressService.findById(id));
	}
	
}

