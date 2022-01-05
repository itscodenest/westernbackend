package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;

public class CustomisePackageItenaryPojoListResponse extends AbstractPojoResponse{

	private List<CustomisedOrderPackageIteneryPojo> customisePackageIteneryPojo;

	public List<CustomisedOrderPackageIteneryPojo> getCustomisePackageIteneryPojo() {
		return customisePackageIteneryPojo;
	}

	public void setCustomisePackageIteneryPojo(List<CustomisedOrderPackageIteneryPojo> customisePackageIteneryPojo) {
		this.customisePackageIteneryPojo = customisePackageIteneryPojo;
	}
	
}
