package com.tourcoreservice.pojo.tourpackage;

import java.util.Set;

public class PlacePojo {
	private long id;
	private String name;
	private String type;
	private Set<MainPlacePojo> mainPlaces;

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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Set<MainPlacePojo> getMainPlaces() {
		return mainPlaces;
	}

	public void setMainPlaces(Set<MainPlacePojo> mainPlaces) {
		this.mainPlaces = mainPlaces;
	}

}
