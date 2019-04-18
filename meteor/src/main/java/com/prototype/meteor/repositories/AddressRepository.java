package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Address;
import com.prototype.meteor.entities.Customer;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {

	List<Address> findByCountryIgnoreCase(String countryName);

	List<Address> findByRegionIgnoreCase(String regionName);

	List<Address> findByCityIgnoreCase(String cityName);

	List<Address> findByStreetIgnoreCase(String streetName);

	Address findByStreetAndNumberIgnoreCase(String streetName, int number);

	List<Address> findByCountryAndRegion(String countryName, String regionName);

	List<Address> findByStreetAndNumber(String streetName, int number);

	Address findByCustomer(Customer customer);

}
