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
import com.tourcoreservice.tourpackage.pojo.IndianPackageSuggestPojo;
import com.tourcoreservice.tourpackage.response.IndianPackageSuggestListResponse;
import com.tourcoreservice.tourpackage.response.IndianPackageSuggestResponse;

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