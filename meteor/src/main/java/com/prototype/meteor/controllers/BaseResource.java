package com.prototype.meteor.controllers;

import com.prototype.meteor.controllers.resources.ErrorDetails;

import org.springframework.http.ResponseEntity;

import com.prototype.meteor.controllers.resources.BodyResponse;
import com.prototype.meteor.controllers.resources.Error;

public interface BaseResource {

	default Error ok() {
		return new Error.Builder()
						.withCode(ErrorDetails.OK.getCode())
						.build();
	}
	
	default Error buildErrorByDetails(ErrorDetails errorDetails) {
		return new Error.Builder()
						.withCode(errorDetails.getCode())
						.withMessage(errorDetails.getMessage())
						.build();
	}
	
	default ResponseEntity buildNoutFoundResponse() {
		return ResponseEntity
					.notFound()
					.build();
	}
	
	default ResponseEntity wrapOrNotFound(Object unsureResponse) {
		if(unsureResponse == null) {
			return buildNoutFoundResponse();
		}
		
		BodyResponse bodyResponse = new BodyResponse.Builder()
											.withSuccess(true)
											.withError(ok())
											.withData(unsureResponse)
											.build();
		
		return ResponseEntity
					.ok()
					.body(bodyResponse);
	}
	
}
