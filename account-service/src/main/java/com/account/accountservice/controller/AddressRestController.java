package com.account.accountservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.account.accountservice.facade.AddressFacade;
import com.tourcoreservice.account.pojo.AddressPojo;
import com.tourcoreservice.account.pojo.UserPojo;
import com.tourcoreservice.account.response.AddressPojoListResponse;
import com.tourcoreservice.account.response.AddressPojoResponse;
import com.tourcoreservice.account.response.UserPojoListResponse;
import com.tourcoreservice.account.response.UserPojoResponse;

@RestController
@RequestMapping("/address")
public class AddressRestController {
	
	@Autowired
	private AddressFacade addressFacade;
	
	@PostMapping
	public AddressPojoResponse create(@RequestBody AddressPojo adressPojo) {
		return addressFacade.create(adressPojo);
		
	}
	
	@GetMapping
	public AddressPojoListResponse getAll() {
		return addressFacade.listAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		addressFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public AddressPojoResponse update(@RequestBody AddressPojo adressPojo, @PathVariable("id") long id) {
		adressPojo.setId(id);
		return addressFacade.update(adressPojo);
	}
	
	

}
