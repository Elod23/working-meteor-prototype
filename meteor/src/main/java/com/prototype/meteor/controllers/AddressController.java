package com.prototype.meteor.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class AddressController implements BaseResource{
	@Autowired
	private AddressService addressService;
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ResponseEntity getAll(){
		return wrapOrNotFound(addressService.findAll());
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity createAddress(Address address) {
		return wrapOrNotFound(addressService.save(address));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity showAddress(@PathVariable Integer id) {
		return wrapOrNotFound(addressService.findById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateAddress(@PathVariable Integer id, @RequestBody Address address) {
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
		return wrapOrNotFound(address);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAddress(@PathVariable Integer id) {
		return wrapOrNotFound(addressService.delete(addressService.findById(id)));
	}
	
}

