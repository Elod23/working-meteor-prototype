package com.prototype.meteor.repositories;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByLegalFormIgnoreCase(String formName);

	List<Customer> findByFirstNameAndLastNameIgnoreCase(String firstName, String lastName);

	List<Customer> findByBirthDate(Date birthDate);

	List<Customer> findByEmail(String email);

	List<Customer> findByTelephoneNumber(String number);

}
