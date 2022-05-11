package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Offerstheme {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long themeid;
	@Column(unique = true)
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

