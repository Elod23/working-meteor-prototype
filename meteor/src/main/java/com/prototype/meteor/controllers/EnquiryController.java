package com.prototype.meteor.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.prototype.meteor.entities.Enquiry;
import com.prototype.meteor.services.EnquiryService;

@RestController
@RequestMapping("/enquiry")
public class EnquiryController implements BaseResource{

	@Autowired
	private EnquiryService enquiryService;
	
	@ResponseBody
	@RequestMapping(path="/", method = RequestMethod.POST)
	public ResponseEntity save(@RequestBody Enquiry enquiry) {
		return wrapOrNotFound(enquiryService.save(enquiry));
	}
	
}
