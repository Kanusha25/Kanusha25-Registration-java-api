package com.example.registration.request;

import java.util.List;

import com.example.regestration.model.Registration;

public class RegistrationRequest {

	private List<Registration> registration;
	private String transactionType;
	public List<Registration> getRegistration() {
		return registration;
	}
	public void setRegistration(List<Registration> registration) {
		this.registration = registration;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	@Override
	public String toString() {
		return "RegistrationRequest [registration=" + registration + ", transactionType=" + transactionType + "]";
	}
	
	

}
