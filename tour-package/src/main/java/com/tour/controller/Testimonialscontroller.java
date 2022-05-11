package com.tour.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.Testimonialsfascade;
import com.tourcoreservice.entity.Testimonials;
import com.tourcoreservice.entity.Testimonialthemes;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonials;
import com.tourcoreservice.response.tourpackage.Testinominalresponse;



@RestController
@RequestMapping("/testimonials")
public class Testimonialscontroller {
	@Autowired
	Testimonialsfascade testimonialsfascade;

	@PostMapping
	public Testinominalresponse save(@RequestBody Pojotestimonials pojotestimonials) {
		return testimonialsfascade.saving(pojotestimonials);
	}

	@PutMapping("/{id}")
	public Testinominalresponse update(@RequestBody Pojotestimonials pojotestimonials, @PathVariable long id) {
		return testimonialsfascade.updating(pojotestimonials, id);
	}

	@DeleteMapping("/{id}")
	public Testinominalresponse delete(@PathVariable long id) {
		return testimonialsfascade.deleting(id);
	}

	@GetMapping("/{id}")
	public Testinominalresponse get(@PathVariable long id) {
		return testimonialsfascade.getting(id);
	}
	@GetMapping("/full/{themeid}")
	public Testinominalresponse getAll(@PathVariable long themeid) {
		return testimonialsfascade.gettingAll(themeid);
	} 
	@GetMapping("/Bythemename/{themename}")
	public List<Testimonials> getAllbytheme(@PathVariable String themename) {
		return testimonialsfascade.gettingAllByTheme(themename);
	} 
	@GetMapping("/alltestimonials")
	public Testinominalresponse getAll() {
		return testimonialsfascade.gettestmoniallist();
	} 

}
