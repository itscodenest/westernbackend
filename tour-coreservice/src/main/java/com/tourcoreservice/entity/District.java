package com.tourcoreservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class District {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;

	@Column(length = 20, unique = true)
	private String name;
	
	@OneToMany(cascade=CascadeType.DETACH,fetch=FetchType.LAZY)
	private List<Taluk> taluks;

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

	public List<Taluk> getTaluks() {
		return taluks;
	}

	public void setTaluks(List<Taluk> taluks) {
		this.taluks = taluks;
	}
	
	
}
