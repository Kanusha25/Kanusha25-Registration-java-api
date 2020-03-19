package com.example.regestration.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.regestration.model.Registration;

@Repository
public interface RegistrationDAO extends JpaRepository<Registration, Integer>
{

	
	
}
