package com.tourcoreservice.pojo.tourpackage;

import java.util.List;

public class DistrictPojo {
	private long id;
	private String name;
	private List<TalukPojo> talukPojoList;

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

	public List<TalukPojo> getTalukPojoList() {
		return talukPojoList;
	}

	public void setTalukPojoList(List<TalukPojo> talukPojoList) {
		this.talukPojoList = talukPojoList;
	}
}
