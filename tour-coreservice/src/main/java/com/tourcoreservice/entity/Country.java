package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
public class Country {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column( unique = true)
	private String name;
	
	@OneToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
	@JoinTable(name = "country_states")
	private Set<States> states;
	
	

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

	public Set<States> getStates() {
		return states;
	}

	public void setStates(Set<States> states) {
		this.states = states;
	}
	
}
