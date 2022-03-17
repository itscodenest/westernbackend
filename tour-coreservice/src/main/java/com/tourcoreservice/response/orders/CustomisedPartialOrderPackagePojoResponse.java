package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.orders.CustomisedPartialOrderPackagePojo;

public class CustomisedPartialOrderPackagePojoResponse {
	
	List<CustomisedPartialOrderPackagePojo> cList;

	public List<CustomisedPartialOrderPackagePojo> getcList() {
		return cList;
	}

	public void setcList(List<CustomisedPartialOrderPackagePojo> cList) {
		this.cList = cList;
	}
	
	

}
