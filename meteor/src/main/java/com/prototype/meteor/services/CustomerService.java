package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.domain.CustomerDTO;
import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.Review;

public interface CustomerService {
	CustomerDTO getCustomerForDisplay(Customer customer);

	Customer findById(Integer id);

	List<Customer> findAll();

	List<CustomerDTO> findAllForDisplay();

	Customer saveDetails(Customer customer);

	CustomerDTO saveLogin(Customer customer);

	Customer update(Integer id, Customer customer);

	Customer delete(Customer customer);

	Customer findByAddress(Address address);

	Address findAddressForCustomer(Customer customer);

	List<Review> findReviewsForCustomer(Customer customer);

}
