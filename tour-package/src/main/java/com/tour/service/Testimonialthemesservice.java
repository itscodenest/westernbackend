package com.tour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tour.repository.Testimonialthemesrepository;
import com.tourcoreservice.entity.Testimonialthemes;

;

@Service
public class Testimonialthemesservice {
	@Autowired
	Testimonialthemesrepository testimonialthemesrepository;

	public Testimonialthemes save(Testimonialthemes testimonialthemes) {

		return testimonialthemesrepository.save(testimonialthemes);

	}

	public Testimonialthemes update(Testimonialthemes testimonialthemes, long themeid) {
		testimonialthemes.setThemeid(themeid);
		return testimonialthemesrepository.save(testimonialthemes);

	}

	public void delete(long themeid) {

		testimonialthemesrepository.deleteById(themeid);

	}

	public Testimonialthemes getbyid(long themeid) {
		return testimonialthemesrepository.findById(themeid);
	}

	public List<Testimonialthemes> Findallthemes() {
		return testimonialthemesrepository.findAll();
	}

	public Testimonialthemes getbythemename(String themename) {
		return testimonialthemesrepository.findByThemename(themename);
	}

}
