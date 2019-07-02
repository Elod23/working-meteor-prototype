package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.domain.CustomerDTO;
import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.services.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController implements BaseResource{
	
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public ResponseEntity getAllCustomerDetails() {
		return wrapOrNotFound(customerService.findAll());
	}
	
	@ResponseBody
	@RequestMapping(path = "/logins", method = RequestMethod.GET)
	public ResponseEntity getAllCustomerLogins() {
		return wrapOrNotFound(customerService.findAllForDisplay());
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public ResponseEntity createCustomerLogin(Customer customer) {
		return wrapOrNotFound(customerService.saveLogin(customer));
	}
	
	
	@ResponseBody
	@RequestMapping(path = "/{id}/details", method = RequestMethod.GET)
	public ResponseEntity showCustomerDetails(@PathVariable Integer id) {
		return wrapOrNotFound(customerService.findById(id));
	}

	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity showCustomerLogin(@PathVariable Integer id) {
		return wrapOrNotFound(customerService.getCustomerForDisplay(customerService.findById(id)));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		return wrapOrNotFound(customerService.update(id, customer));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteCustomer(@PathVariable Integer id) {
		return wrapOrNotFound(customerService.delete(customerService.findById(id)));
	}
	

}
