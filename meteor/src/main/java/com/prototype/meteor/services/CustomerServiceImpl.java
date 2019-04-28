package com.prototype.meteor.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.domain.CustomerDTO;
import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.GenericBuilder;
import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.Review;
import com.prototype.meteor.entities.ShoppingCart;
import com.prototype.meteor.repositories.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public CustomerDTO getCustomerForDisplay(Customer customer) {
		return GenericBuilder.of(CustomerDTO::new)
				.with(CustomerDTO::setName, customer.getFirstName() + " " + customer.getLastName())
				.with(CustomerDTO::setEmail, customer.getEmail())
				.with(CustomerDTO::setBirthdate, customer.getBirthDate())
				.with(CustomerDTO::setPassword, customer.getPassword()).build();
	}

	private Customer convertDTOToDb(CustomerDTO customerDTO) {
		return GenericBuilder.of(Customer::new)
				.with(Customer::setFirstName, customerDTO.getName().substring(0, customerDTO.getName().indexOf(" ")))
				.with(Customer::setLastName,
						customerDTO.getName().substring(customerDTO.getName().indexOf(" "),
								customerDTO.getName().length()))
				.with(Customer::setEmail, customerDTO.getEmail())
				.with(Customer::setBirthDate, customerDTO.getBirthdate())
				.with(Customer::setPassword, customerDTO.getPassword()).build();
	}

	@Override
	public Customer findById(Integer id) {
		return customerRepository.getOne(id);
	}

	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}

	@Override
	public List<CustomerDTO> findAllForDisplay() {
		List<CustomerDTO> customerDTOs = new ArrayList<>();

		List<Customer> customers = customerRepository.findAll();

		for (Customer customer : customers) {
			customerDTOs.add(this.getCustomerForDisplay(customer));
		}
		return customerDTOs;
	}

	@Override
	public CustomerDTO saveLogin(Customer customer) {
		return this.getCustomerForDisplay(customerRepository.save(customer));
	}

	@Override
	public Customer saveDetails(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Integer id, Customer customer) {
		Customer changedCustomer = customerRepository.getOne(id);

		if (customer.getFirstName() != null) {
			changedCustomer.setFirstName(customer.getFirstName());
		}
		if (customer.getLastName() != null) {
			changedCustomer.setLastName(changedCustomer.getLastName());
		}
		if (customer.getLegalForm() != null) {
			changedCustomer.setLegalForm(customer.getLegalForm());
		}
		if (customer.getBirthDate() != null) {
			changedCustomer.setBirthDate(customer.getBirthDate());
		}
		if (customer.getEmail() != null) {
			changedCustomer.setEmail(customer.getEmail());
		}
		if (customer.getPassword() != null) {
			changedCustomer.setPassword(customer.getPassword());
		}
		if (customer.getTelephoneNumber() != null) {
			changedCustomer.setTelephoneNumber(customer.getTelephoneNumber());
		}
		if (customer.getAddress() != null) {
			changedCustomer.setAddress(customer.getAddress());
		}
		if (customer.getOrders() != null) {
			changedCustomer.getOrders().addAll(customer.getOrders());
		}
		if (customer.getReviews() != null) {
			changedCustomer.getReviews().addAll(customer.getReviews());
		}
		if (customer.getShoppingCart() != null) {
			changedCustomer.setShoppingCart(customer.getShoppingCart());
		}
		changedCustomer.setCustomerId(id);

		return changedCustomer;
	}

	@Override
	public Customer delete(Customer customer) {
		customerRepository.delete(customer);
		return customer;
	}

	@Override
	public Customer findByAddress(Address address) {
		return customerRepository.findByAddress(address);
	}

	@Override
	public Address findAddressForCustomer(Customer customer) {
		return customer.getAddress();
	}

	@Override
	public ShoppingCart findCartForCustomer(Customer customer) {
		return customer.getShoppingCart();
	}

	@Override
	public Customer findByShoppingCart(ShoppingCart shoppingCart) {
		return customerRepository.findByShoppingCart(shoppingCart);
	}

	@Override
	public List<Order> findOrdersForCustomer(Customer customer) {
		return customer.getOrders();
	}

	@Override
	public List<Review> findReviewsForCustomer(Customer customer) {
		return customer.getReviews();
	}

	public Customer resetShoppingCartAfterCheckout(Customer customer) {
		customer.setShoppingCart(null);
		return customer;
	}

}
