package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class MainPlacePojo {
	private Long id;
	 private String name;
	 private List<PlacePojo> placePojoList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PlacePojo> getPlacePojoList() {
		return placePojoList;
	}
	public void setPlacePojoList(List<PlacePojo> placePojoList) {
		this.placePojoList = placePojoList;
	}
	

}
