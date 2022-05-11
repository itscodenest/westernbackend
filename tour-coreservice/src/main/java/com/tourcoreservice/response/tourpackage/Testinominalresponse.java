package com.tourcoreservice.response.tourpackage;
import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonials;

public class Testinominalresponse extends AbstractPojoResponse {
	private Pojotestimonials pojotestimonials;
	private List<Pojotestimonials> pojotestimonialslist;

	public Pojotestimonials getPojotestimonials() {
		return pojotestimonials;
	}

	public void setPojotestimonials(Pojotestimonials pojotestimonials) {
		this.pojotestimonials = pojotestimonials;
	}

	public List<Pojotestimonials> getPojotestimonialslist() {
		return pojotestimonialslist;
	}

	public void setPojotestimonialslist(List<Pojotestimonials> pojotestimonialslist) {
		this.pojotestimonialslist = pojotestimonialslist;
	}

	
	

}