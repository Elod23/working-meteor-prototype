package com.prototype.meteor.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.prototype.meteor.entities.Enquiry;

@Component
public class EnquiryValidator implements RequestValidator<Enquiry>{
	

	@Override
	public boolean validate(Enquiry t) {
		Pattern pattern  = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(t.getEmail());
		if(matcher.find()) {
			if(t.getMessageBody() != null && t.getMessageBody() != "") {
				if(t.getUserName() != null && t.getUserName() != "") {
					return true;
				}
			}
		}
		return false;
	}

}
