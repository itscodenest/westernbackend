package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.accountservice.facade.CustomerProfileFacade;
import com.tourcoreservice.pojo.account.CustomerProfilePojo;
import com.tourcoreservice.response.account.CustomerProfilePojoResponse;

@RestController
@RequestMapping("/Customers")
public class CustomerProfileController {
	
	@Autowired
	private CustomerProfileFacade tFacad;

	@PostMapping
	public CustomerProfilePojoResponse create(@RequestBody CustomerProfilePojo userPojo) {
		return tFacad.create(userPojo);
	}

	

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		tFacad.delete(id);
	}

	@PutMapping("/{id}")
	public CustomerProfilePojoResponse update(@RequestBody CustomerProfilePojo userPojo, @PathVariable("id") long id) {
		userPojo.setId(id);
		return tFacad.update(userPojo);
	}

	@GetMapping("/{id}")
	public CustomerProfilePojoResponse getbyid( @PathVariable("id") long id) {
		return tFacad.getTravellerById(id);
	}
	
	@GetMapping("byuserid/{id}")
	public CustomerProfilePojoResponse getprofilebyTravellerid( @PathVariable("id") String id) {
		return tFacad.getProfileBuTravellerid(id);
	}
}
