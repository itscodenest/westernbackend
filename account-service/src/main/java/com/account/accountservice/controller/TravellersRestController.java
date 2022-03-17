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
import com.account.accountservice.facade.TravellersFacad;
import com.tourcoreservice.pojo.account.TravellersPojo;
import com.tourcoreservice.response.account.TravellersPojoListResponse;
import com.tourcoreservice.response.account.TravellersPojoResponse;

@RestController
@RequestMapping("/travellers")
public class TravellersRestController {

	@Autowired
	private TravellersFacad tFacad;

	@PostMapping
	public TravellersPojoResponse create(@RequestBody TravellersPojo userPojo) {
		return tFacad.create(userPojo);
	}

	@GetMapping
	public TravellersPojoListResponse getAll() {
		return tFacad.listAll();
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		tFacad.delete(id);
	}

	@PutMapping("/{id}")
	public TravellersPojoResponse update(@RequestBody TravellersPojo userPojo, @PathVariable("id") String id) {
		userPojo.setId(id);
		return tFacad.update(userPojo);
	}

	@GetMapping("/{id}")
	public TravellersPojoResponse getbyid( @PathVariable("id") String id) {
		return tFacad.getTravellerById(id);
	}
	
	
}
