package com.tourcoreservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Taluk {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(length = 20, unique = true)
	private String name;
	
	@OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	@JoinColumn(name="mainplace_id")
	private List<MainPlace> mainPlaces;

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

	public List<MainPlace> getMainPlaces() {
		return mainPlaces;
	}

	public void setMainPlaces(List<MainPlace> mainPlaces) {
		this.mainPlaces = mainPlaces;
	}
	

}
