package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class RegionPojo {

	private long id;
	private String name;

	private List<CountryPojo> countryPojoList;

	public List<CountryPojo> getCountryPojoList() {
		return countryPojoList;
	}

	public void setCountryPojoList(List<CountryPojo> countryPojoList) {
		this.countryPojoList = countryPojoList;
	}

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
}
