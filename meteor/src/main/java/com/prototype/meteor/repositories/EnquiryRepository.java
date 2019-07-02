package com.prototype.meteor.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prototype.meteor.entities.Enquiry;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Integer>{
	
	List<Enquiry> findByUserName(String userName);
	
	List<Enquiry> findByEmail(String email);
	
	List<Enquiry> findByMessageBodyLike(String searchToken);
	

}
