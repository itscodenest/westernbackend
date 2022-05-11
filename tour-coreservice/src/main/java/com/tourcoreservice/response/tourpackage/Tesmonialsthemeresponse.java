package com.tourcoreservice.response.tourpackage;
import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.Pojotestimonialthemes;

public class Tesmonialsthemeresponse extends AbstractPojoResponse{
	private Pojotestimonialthemes pojotestimonialtheme;
	private List<Pojotestimonialthemes> listtheme;
	public Pojotestimonialthemes getPojotestimonialtheme() {
		return pojotestimonialtheme;
	}
	public void setPojotestimonialtheme(Pojotestimonialthemes pojotestimonialtheme) {
		this.pojotestimonialtheme = pojotestimonialtheme;
	}
	public List<Pojotestimonialthemes> getListtheme() {
		return listtheme;
	}
	public void setListtheme(List<Pojotestimonialthemes> listtheme) {
		this.listtheme = listtheme;
	}
	

}
