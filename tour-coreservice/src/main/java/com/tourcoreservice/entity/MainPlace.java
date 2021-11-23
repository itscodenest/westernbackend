package com.tourcoreservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class MainPlace {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;
	
	@OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="subplaces_id")
	private List<Place> subplaces;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Place> getSubplaces() {
		return subplaces;
	}

	public void setSubplaces(List<Place> subplaces) {
		this.subplaces = subplaces;
	}
	
	
}