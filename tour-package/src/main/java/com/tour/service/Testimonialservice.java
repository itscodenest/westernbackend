package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.Testimonialsrepository;
import com.tourcoreservice.entity.Testimonials;
import com.tourcoreservice.entity.Testimonialthemes;


@Service
public class Testimonialservice {
	@Autowired
	Testimonialsrepository testimonialsrepository;

	public Testimonials save(Testimonials testimonials) {
		return testimonialsrepository.save(testimonials);
	}

	public Testimonials update(Testimonials testimonials, long id) {
		testimonials.setId(id);
		return testimonialsrepository.save(testimonials);
	}

	public void delete(long id) {
		testimonialsrepository.deleteById(id);

	}
	public Testimonials get(long id) {
		return testimonialsrepository.findById(id).get();
	}

	public List<Testimonials> getting(long themeid) {
		return testimonialsrepository.findAllById(themeid);
	}
	public List<Testimonials> gettestmoniallist() {
		return testimonialsrepository.findAll();
	}

	public List<Testimonials> getAllTestimonialsByThemename(Testimonialthemes testimonialthemes) {
		return testimonialsrepository.findAllByTestimonialthemes(testimonialthemes);
	}


}
