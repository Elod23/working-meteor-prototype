package com.prototype.meteor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prototype.meteor.entities.Enquiry;
import com.prototype.meteor.exceptions.EmailNotFoundException;
import com.prototype.meteor.exceptions.UsernameNotFoundException;
import com.prototype.meteor.repositories.EnquiryRepository;

@Service
public class EnquiryServiceImpl implements EnquiryService{
	
	private EnquiryRepository enquiryRepository;

	@Autowired
	public EnquiryServiceImpl(EnquiryRepository enquiryRepository) {
		this.enquiryRepository = enquiryRepository;
	}
	
	@Override
	public Enquiry save(Enquiry enquiry) {
		return enquiryRepository.save(enquiry);
	}

	@Override
	public Enquiry findById(Integer id) {
		return enquiryRepository.getOne(id);
	}

	@Override
	public List<Enquiry> findAll() {
		return enquiryRepository.findAll();
	}

	@Override
	public List<Enquiry> findByEmail(String email) throws EmailNotFoundException {
		if(enquiryRepository.findByEmail(email) == null) {
			throw new EmailNotFoundException("There is no enquiry with the serached email address:" + email);
		}else {
			return enquiryRepository.findByEmail(email);
		}
	}

	@Override
	public List<Enquiry> findByUserName(String userName) throws UsernameNotFoundException{
		if(enquiryRepository.findByUserName(userName) != null) {
			return enquiryRepository.findByUserName(userName);
		}else {
			throw new UsernameNotFoundException("There is no enquiry for username:" + userName);
		}
	}
	
}
