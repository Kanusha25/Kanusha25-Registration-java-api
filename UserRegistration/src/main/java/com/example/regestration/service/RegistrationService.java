package com.example.regestration.service;

import org.springframework.http.ResponseEntity;
import com.example.registration.request.RegistrationRequest;

public interface RegistrationService {
	ResponseEntity<Object> saveUserRegistrationDetails(RegistrationRequest registrationRequest);
	

}
