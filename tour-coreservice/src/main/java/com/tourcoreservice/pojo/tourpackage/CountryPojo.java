package com.tourcoreservice.pojo.tourpackage;

import java.util.Set;

public class CountryPojo {

	private long id;
	private String name;
	private Set<StatesPojo> states;
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
	public Set<StatesPojo> getStates() {
		return states;
	}
	public void setStates(Set<StatesPojo> states) {
		this.states = states;
	}


}
