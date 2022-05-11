package com.tourcoreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Testimonialthemes {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long themeid;
	private String themename;
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




}
