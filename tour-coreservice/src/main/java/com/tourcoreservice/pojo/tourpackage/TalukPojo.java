package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class TalukPojo {
	private long id;
	private String name;
	private List<MainPlacePojo> mainPlacePojoList;

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

	public List<MainPlacePojo> getMainPlacePojoList() {
		return mainPlacePojoList;
	}

	public void setMainPlacePojoList(List<MainPlacePojo> mainPlacePojoList) {
		this.mainPlacePojoList = mainPlacePojoList;
	}
	
}
