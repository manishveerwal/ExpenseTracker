package org.expense.spring.mvc.model;

import java.io.Serializable;

public class EmailValidationJSON implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6588064426134712918L;
	
	private boolean available;
	private String message;
	
	public EmailValidationJSON() {
	}

	public EmailValidationJSON(boolean available, String message) {
		this.available = available;
		this.message = message;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public void setAvailable(boolean available) {
		this.available = available;
	}

	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
}
