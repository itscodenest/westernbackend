package com.tour.controller;

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

import com.tour.facade.InterNatPackageSuggestFacade;
import com.tourcoreservice.tourpackage.pojo.InterNatPackageSuggestPojo;
import com.tourcoreservice.tourpackage.response.InterNatPackageSuggestListResponse;
import com.tourcoreservice.tourpackage.response.InterNatPackageSuggestResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/InterNatPackagesuggest")
public class InterNatPackageSuggestController {
	
	@Autowired
	InterNatPackageSuggestFacade interNatPackageSuggestFacade ;

	@PostMapping
	public InterNatPackageSuggestResponse create(@RequestBody InterNatPackageSuggestPojo packageSuggestPojo) {
		return interNatPackageSuggestFacade.create(packageSuggestPojo);
	}
	
	@GetMapping
	public InterNatPackageSuggestListResponse getall() {
		return interNatPackageSuggestFacade.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		interNatPackageSuggestFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public InterNatPackageSuggestResponse update(@RequestBody InterNatPackageSuggestPojo packageSuggestPojo, @PathVariable("id") long id) {
		packageSuggestPojo.setId(id);
		return interNatPackageSuggestFacade.update(packageSuggestPojo);
	}
}
