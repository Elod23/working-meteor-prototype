package com.prototype.meteor.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Customer;
import com.prototype.meteor.entities.Order;
import com.prototype.meteor.entities.Review;
import com.prototype.meteor.entities.ShoppingCart;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	Customer findByCustomerId(Integer customerId);

	List<Customer> findByLegalFormIgnoreCase(String formName);

	List<Customer> findByLegalFormIgnoreCaseLike(String formName);

	List<Customer> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);
	
	List<Customer> findByFirstNameIgnoreCase(String firstName);
	
	List<Customer> findByLastNameIgnoreCase(String lastName);

	List<Customer> findByBirthDate(Date birthDate);

	List<Customer> findByEmailIgnoreCase(String email);

	List<Customer> findByEmail(String email);
	
	List<Customer> findByEmailIgnoreCaseLike(String email);

	List<Customer> findByTelephoneNumber(String number);

	Customer findByShoppingCart(ShoppingCart shoppingCart);

	Customer findByAddress(Address address);

	Customer findByOrders(List<Order> orders);

	Customer findByReviews(List<Review> reviews);

}
