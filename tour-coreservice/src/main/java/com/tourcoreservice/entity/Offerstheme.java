package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Offerstheme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long themeid;
	private String themename;
	
	@OneToMany(mappedBy="offerstheme")
    private Set<Offers> offers;
	
	
    
	public long getThemeid() {
		return themeid;
	}

	public void setThemeid(long themeid) {
		this.themeid = themeid;
	}

	public String getThemename() {
		return themename;
	}

	public void setThemename(String themename) {
		this.themename = themename;
	}

	public Set<Offers> getOffers() {
		return offers;
	}

	public void setOffers(Set<Offers> offers) {
		this.offers = offers;
	}
	
	

}

