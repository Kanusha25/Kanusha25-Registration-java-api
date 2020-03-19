package com.example.regestration.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.regestration.constants.ErrorResponse;
import com.example.regestration.model.Registration;
import com.example.regestration.service.RegistrationServiceImpl;
import com.example.registration.request.RegistrationRequest;

@RestController
@RequestMapping("/registration")
public class RegistrationController {

	@Autowired
	private RegistrationServiceImpl registrationServiceImpl;

	@PostMapping("/register")
	public ResponseEntity<Object> setCustomerContactInfo(@RequestBody RegistrationRequest registrationRequest,
			HttpServletRequest servletRequest, HttpServletResponse servletResponse) throws IOException {

		List<Registration> registrationDetailsList = registrationRequest.getRegistration();

		try {
			if ((registrationRequest == null) || (registrationRequest.getRegistration() == null)) {
				ErrorResponse error = new ErrorResponse();
				error.setStatusCode("422");
				error.setStatusMessage("reqest object is null");
				return new ResponseEntity<Object>(error, HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if (registrationRequest.getTransactionType().equalsIgnoreCase("register")) {
				for (Registration registration : registrationDetailsList) {
					if (registration.getFirstName() == null && registration.getLastName() == null
							&& registration.getEmail() == null) {
						ErrorResponse error = new ErrorResponse();
						error.setStatusCode("422");
						error.setStatusMessage(" field is null");
						return new ResponseEntity<>(error, HttpStatus.UNPROCESSABLE_ENTITY);
					}
				}
				return registrationServiceImpl.saveUserRegistrationDetails(registrationRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
			ErrorResponse error = new ErrorResponse();
			error.setStatusCode("409");
			error.setStatusMessage("failed");
			return new ResponseEntity<>(error, HttpStatus.CONFLICT);
		}
		return null;

	}

}
