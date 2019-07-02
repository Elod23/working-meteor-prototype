package com.prototype.meteor.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="enquiries")
public class Enquiry {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="enquiry_id")
	private Integer enquiryId;
	
	@NotNull
	@Column(name="sender")
	private String userName;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	@Column(name="text")
	private String messageBody;

	public Integer getEnquiryId() {
		return enquiryId;
	}

	public void setEnquiryId(Integer enquiryId) {
		this.enquiryId = enquiryId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessageBody() {
		return messageBody;
	}

	public void setMessageBody(String messageBody) {
		this.messageBody = messageBody;
	}
	
}
