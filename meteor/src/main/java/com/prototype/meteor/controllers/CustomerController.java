package com.prototype.meteor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@ResponseBody
	@RequestMapping(path = "/details", method = RequestMethod.GET)
	public List<Customer> getAllCustomerDetails() {
		return customerService.findAll();
	}
	
	@ResponseBody
	@RequestMapping(path = "/logins", method = RequestMethod.GET)
	public List<CustomerDTO> getAllCustomerLogins() {
		return customerService.findAllForDisplay();
	}
	
	@ResponseBody
	@RequestMapping(path = "/", method = RequestMethod.POST)
	public CustomerDTO createCustomerLogin(Customer customer) {
		return customerService.saveLogin(customer);
	}
	
	
	@ResponseBody
	@RequestMapping(path = "/{id}/details", method = RequestMethod.GET)
	public Customer showCustomerDetails(@PathVariable Integer id) {
		return customerService.findById(id);
	}

	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public CustomerDTO showCustomerLogin(@PathVariable Integer id) {
		return customerService.getCustomerForDisplay(customerService.findById(id));
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public Customer updateCustomer(@PathVariable Integer id, @RequestBody Customer customer) {
		return customerService.update(id, customer);
	}
	
	@ResponseBody
	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public Customer deleteCustomer(@PathVariable Integer id) {
		return customerService.delete(customerService.findById(id));
	}
	

}
