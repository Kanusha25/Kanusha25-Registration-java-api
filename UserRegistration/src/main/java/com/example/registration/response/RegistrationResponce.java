package com.example.registration.response;

import java.util.List;

import com.example.regestration.model.Registration;


public class RegistrationResponce {
	
	private String message;
	private String statusCode;
	private List<Registration> registrationList;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public List<Registration> getRegistrationList() {
		return registrationList;
	}
	public void setRegistrationList(List<Registration> registrationList) {
		this.registrationList = registrationList;
	}
	@Override
	public String toString() {
		return "RegistrationResponce [message=" + message + ", statusCode=" + statusCode + ", registrationList="
				+ registrationList + "]";
	}

}
