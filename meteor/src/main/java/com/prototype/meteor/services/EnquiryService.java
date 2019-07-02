package com.prototype.meteor.services;

import java.util.List;

import com.prototype.meteor.entities.Enquiry;
import com.prototype.meteor.exceptions.EmailNotFoundException;
import com.prototype.meteor.exceptions.UsernameNotFoundException;

public interface EnquiryService {
	
	Enquiry save(Enquiry enquiry);
	
	Enquiry findById(Integer id);
	
	List<Enquiry> findAll();
	
	List<Enquiry> findByEmail(String email) throws EmailNotFoundException;
	
	List<Enquiry> findByUserName(String userName) throws UsernameNotFoundException;

}
