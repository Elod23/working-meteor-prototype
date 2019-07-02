package com.prototype.meteor.controllers.resources;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class Error {

	private int code;
	private String message;

	private Error(int code, String message) {
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

	public static class Builder {
		private int code;
		private String message;

		public Builder withCode(int code) {
			this.code = code;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public Error build() {
			return new Error(code, message);
		}
	}
}

