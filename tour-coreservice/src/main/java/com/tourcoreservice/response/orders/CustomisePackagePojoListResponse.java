package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackagePojo;

public class CustomisePackagePojoListResponse extends AbstractPojoResponse{

	private List<CustomisedOrderPackagePojo> customisePackagePojo;

	public List<CustomisedOrderPackagePojo> getCustomisePackagePojo() {
		return customisePackagePojo;
	}

	public void setCustomisePackagePojo(List<CustomisedOrderPackagePojo> customisePackagePojo) {
		this.customisePackagePojo = customisePackagePojo;
	}
	
}
