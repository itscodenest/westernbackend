package com.account.accountservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.account.accountservice.repository.CustomerProfileRepository;
import com.tourcoreservice.entity.CustomerProfile;


@Service
public class CustomerProfileService {
	
	@Autowired
	CustomerProfileRepository cProfileRepository;
	
	
	public CustomerProfile create(CustomerProfile cProfile) {
		return cProfileRepository.save(cProfile);
	}

	

	public CustomerProfile findById(long id) {

		return cProfileRepository.findById(id);
	}

	public CustomerProfile findbyuserid(String travellerid) {
		return cProfileRepository.findByuserid(travellerid);
	}
	public CustomerProfile update(CustomerProfile cProfile) {
		return cProfileRepository.save(cProfile);
	}

	public void delete(long id) {

		cProfileRepository.deleteById(id);
	}


}
