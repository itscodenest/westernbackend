package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.Testimonialthemesservice;
import com.tourcoreservice.entity.Testimonialthemes;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonialthemes;
import com.tourcoreservice.response.tourpackage.Tesmonialsthemeresponse;
import com.tourcoreservice.util.ObjectMapperUtils;


@Component
public class Testimonialsthemefascade {
	@Autowired
	Testimonialthemesservice testimonialthemesservice;

	public Tesmonialsthemeresponse save(Pojotestimonialthemes pojotestimonialthemes) {
		Tesmonialsthemeresponse response=new Tesmonialsthemeresponse();
		Testimonialthemes testimonialthemes = ObjectMapperUtils.map(pojotestimonialthemes, Testimonialthemes.class);
		testimonialthemes = testimonialthemesservice.save(testimonialthemes);
		pojotestimonialthemes = ObjectMapperUtils.map(testimonialthemes, Pojotestimonialthemes.class);
		response.setPojotestimonialtheme(pojotestimonialthemes);
		return response;
	}

	public Tesmonialsthemeresponse update(Pojotestimonialthemes pojotestimonialthemes, long themeid) {
		Tesmonialsthemeresponse response=new Tesmonialsthemeresponse();
		Testimonialthemes testimonialthemes = ObjectMapperUtils.map(pojotestimonialthemes, Testimonialthemes.class);
		testimonialthemes = testimonialthemesservice.update(testimonialthemes, themeid);
		pojotestimonialthemes = ObjectMapperUtils.map(testimonialthemes, Pojotestimonialthemes.class);
		response.setPojotestimonialtheme(pojotestimonialthemes);
		return response;
	}

	public Pojotestimonialthemes delete(long themeid) {

		testimonialthemesservice.delete(themeid);
		return null;
	}

	public Tesmonialsthemeresponse getbyid(long themeid) {
		Tesmonialsthemeresponse response=new Tesmonialsthemeresponse();
		Testimonialthemes testimonialthemes=testimonialthemesservice.getbyid(themeid);
		Pojotestimonialthemes pojotestimonialthemes=ObjectMapperUtils.map(testimonialthemes, Pojotestimonialthemes.class);
		response.setPojotestimonialtheme(pojotestimonialthemes);
		return response;
	}

	public Tesmonialsthemeresponse getallthe() {
		Tesmonialsthemeresponse response=new Tesmonialsthemeresponse();
		List<Testimonialthemes> testimonialthemes=testimonialthemesservice.Findallthemes();
		List<Pojotestimonialthemes> pojotestimonialthemes=ObjectMapperUtils.mapAll(testimonialthemes, Pojotestimonialthemes.class);
		response.setListtheme(pojotestimonialthemes);
		return response;

	}

	public Pojotestimonialthemes findByThemename(String themename) {
		Testimonialthemes testimonialthemes=testimonialthemesservice.getbythemename(themename);
		Pojotestimonialthemes pojotestimonialthemes=ObjectMapperUtils.map(testimonialthemes, Pojotestimonialthemes.class);
		return pojotestimonialthemes;
	}

	


}
