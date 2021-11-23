package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class StatesPojo {

	private long id;
	private String name;
	private List<DistrictPojo> districtPojoList;

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
	public List<DistrictPojo> getDistrictPojoList() {
		return districtPojoList;
	}
	public void setDistrictPojoList(List<DistrictPojo> districtPojoList) {
		this.districtPojoList = districtPojoList;
	}
	
	
}
