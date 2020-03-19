package com.example.regestration.service;

import java.util.List;

import javax.mail.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import com.example.regestration.dao.RegistrationDAO;
import com.example.regestration.model.Registration;
import com.example.registration.request.RegistrationRequest;
import com.example.registration.response.RegistrationResponce;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	private RegistrationDAO registrationDAO;

	@Autowired
	JavaMailSender javaMailSender;

	@Autowired
	Environment env;

	@Override
	public ResponseEntity<Object> saveUserRegistrationDetails(RegistrationRequest registrationRequest) {

		RegistrationResponce registrationResponce = null;

		if (registrationRequest.getTransactionType().equalsIgnoreCase("register")) {
			registrationResponce = new RegistrationResponce();

			List<Registration> registrations = registrationRequest.getRegistration();

			for (Registration registration : registrations) {
				Registration registrationDetails = registrationDAO.save(registration);

				if (registrationRequest.getRegistration().get(0).getEmail() != null) {

					SimpleMailMessage mailMessage = new SimpleMailMessage();
					mailMessage.setTo(registrationDetails.getEmail());
					mailMessage.setSubject("Registration Status");
					mailMessage.setText("Registration Successfully done! ");
					
					javaMailSender.send(mailMessage);
				}

				if (registrationDetails != null) {
					registrationResponce.setStatusCode("200");
					registrationResponce.setMessage("Registration Details Saved Successfully");
					return new ResponseEntity<>(registrationResponce, HttpStatus.OK);
				} else {
					registrationResponce.setStatusCode("409");
					registrationResponce.setMessage("failed to save");
					return new ResponseEntity<>(registrationResponce, HttpStatus.UNPROCESSABLE_ENTITY);
				}

			}

		}
		return new ResponseEntity<>(registrationResponce, HttpStatus.OK);

	}

}
