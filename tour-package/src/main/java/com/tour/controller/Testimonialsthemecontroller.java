package com.tour.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tour.facade.Testimonialsthemefascade;
import com.tourcoreservice.entity.Testimonialthemes;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonialthemes;
import com.tourcoreservice.response.tourpackage.Tesmonialsthemeresponse;

@RestController
@RequestMapping("/testimonialthemes")
public class Testimonialsthemecontroller {
	@Autowired
	Testimonialsthemefascade testimonialsthemefascade;

	@PostMapping
	public Tesmonialsthemeresponse save(@RequestBody Pojotestimonialthemes pojotestimonialthemes) {
		return testimonialsthemefascade.save(pojotestimonialthemes);
	}

	@DeleteMapping("/{themeid}")
	public void deletetheme(@PathVariable long themeid) {
		testimonialsthemefascade.delete(themeid);

	}

	@PutMapping("/{themeid}")
	public Tesmonialsthemeresponse update(@RequestBody Pojotestimonialthemes pojotestimonialthemes,
			@PathVariable long themeid) {
		return testimonialsthemefascade.update(pojotestimonialthemes, themeid);
	}

	@GetMapping("/{themeid}")
	public Tesmonialsthemeresponse getid(@PathVariable long themeid) {
		return testimonialsthemefascade.getbyid(themeid);
	}
	@GetMapping("/bythemename/{themename}")
	public Pojotestimonialthemes getthemename(@PathVariable String themename) {
		return testimonialsthemefascade.findByThemename(themename);
	}
	@GetMapping("/alltheme")
	public Tesmonialsthemeresponse getall() {
		return testimonialsthemefascade.getallthe();
	}	
}
