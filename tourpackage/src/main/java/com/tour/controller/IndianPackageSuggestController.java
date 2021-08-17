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

import com.tour.facade.IndianPackageSuggestFacade;
import com.tour.pojo.IndianPackageSuggestPojo;
import com.tour.pojo.InterNatPackageSuggestPojo;
import com.tour.response.IndianPackageSuggestListResponse;
import com.tour.response.IndianPackageSuggestResponse;
import com.tour.response.InterNatPackageSuggestListResponse;
import com.tour.response.InterNatPackageSuggestResponse;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/IndianPackagesuggest")
public class IndianPackageSuggestController {
	
	@Autowired
	IndianPackageSuggestFacade indianPackageSuggestFacade;
	
	@PostMapping
	public IndianPackageSuggestResponse create(@RequestBody IndianPackageSuggestPojo packageSuggestPojo) {
		return indianPackageSuggestFacade.create(packageSuggestPojo);
	}
	
	@GetMapping
	public IndianPackageSuggestListResponse getall() {
		return indianPackageSuggestFacade.getAll();
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		indianPackageSuggestFacade.delete(id);
	}
	
	@PutMapping("/{id}")
	public IndianPackageSuggestResponse update(@RequestBody IndianPackageSuggestPojo packageSuggestPojo, @PathVariable("id") long id) {
		packageSuggestPojo.setId(id);
		return indianPackageSuggestFacade.update(packageSuggestPojo);
	}
	

}
