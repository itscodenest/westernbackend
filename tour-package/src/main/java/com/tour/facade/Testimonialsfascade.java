package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.service.Testimonialservice;
import com.tour.service.Testimonialthemesservice;
import com.tourcoreservice.entity.Testimonials;
import com.tourcoreservice.entity.Testimonialthemes;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonials;
import com.tourcoreservice.response.tourpackage.Testinominalresponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class Testimonialsfascade {
	@Autowired
	Testimonialservice testimonialservice;
	@Autowired
	Testimonialthemesservice testimonialthemesservice;

	public Testinominalresponse saving(Pojotestimonials pojotestimonials) {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {
			
			Testimonials testimonials = ObjectMapperUtils.map(pojotestimonials, Testimonials.class);
			testimonials = testimonialservice.save(testimonials);
			pojotestimonials = ObjectMapperUtils.map(testimonials, Pojotestimonials.class);
			testinominalresponse.setPojotestimonials(pojotestimonials);
			responseMessagePojo.setSuccessMessage("Testinomial save successfully");
			
			return testinominalresponse;
		} catch (Exception e) {
			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_ACCEPTABLE);
			return testinominalresponse;
		}
	}

	public Testinominalresponse updating(Pojotestimonials pojotestimonials, long id) {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {
			Testimonials testimonials = ObjectMapperUtils.map(pojotestimonials, Testimonials.class);
			testimonials = testimonialservice.update(testimonials, id);
			pojotestimonials = ObjectMapperUtils.map(testimonials, Pojotestimonials.class);
			testinominalresponse.setPojotestimonials(pojotestimonials);
			responseMessagePojo.setSuccessMessage("Update successfully");
			
			return testinominalresponse;
		} catch (Exception e) {

			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_FOUND);
			return testinominalresponse;
		}

	}

	public Testinominalresponse deleting(long id) {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {
			testimonialservice.delete(id);
			responseMessagePojo.setSuccessMessage("Deleted succesfully");
			
			return testinominalresponse;
		} catch (Exception e) {
			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_FOUND);
			
			return testinominalresponse;
		}
	}

	public Testinominalresponse getting(long id) {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {
			Testimonials testimonials = testimonialservice.get(id);
			Pojotestimonials pojotestimonials = ObjectMapperUtils.map(testimonials, Pojotestimonials.class);
			testinominalresponse.setPojotestimonials(pojotestimonials);
			responseMessagePojo.setSuccessMessage("Values got succesfully");
			
			return testinominalresponse;
		} catch (Exception e) {
			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_FOUND);
			
			return testinominalresponse;
		}
	}

	public Testinominalresponse gettingAll(long themeid) {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {

			List<Testimonials> testimonials = testimonialservice.getting(themeid);
			List<Pojotestimonials> pojotestimonials = ObjectMapperUtils.mapAll(testimonials, Pojotestimonials.class);
			testinominalresponse.setPojotestimonialslist(pojotestimonials);
			responseMessagePojo.setSuccessMessage("Values got succesfully");
			
			return testinominalresponse;
		} catch (Exception e) {
			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_FOUND);
			
			return testinominalresponse;

		}
	}

	public Testinominalresponse gettestmoniallist() {
		Testinominalresponse testinominalresponse = new Testinominalresponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();

		try {

			List<Testimonials> testimonials = testimonialservice.gettestmoniallist();
			List<Pojotestimonials> pojotestimonials = ObjectMapperUtils.mapAll(testimonials, Pojotestimonials.class);
			testinominalresponse.setPojotestimonialslist(pojotestimonials);
			responseMessagePojo.setSuccessMessage("Values got succesfully");
			
			return testinominalresponse;
		} catch (Exception e) {
			responseMessagePojo.setErrorMessage(e.toString());
			responseMessagePojo.setStatus(HttpStatus.NOT_FOUND);
			
			return testinominalresponse;

		}
	}

	public List<Testimonials> gettingAllByTheme(String themename) {
	

			Testimonialthemes testimonialthemes = testimonialthemesservice.getbythemename(themename);
			List<Testimonials> testimonials=testimonialservice.getAllTestimonialsByThemename(testimonialthemes);
			return testimonials;
		
	
}
}
