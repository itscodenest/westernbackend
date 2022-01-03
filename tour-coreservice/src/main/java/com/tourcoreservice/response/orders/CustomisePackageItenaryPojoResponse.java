package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;

public class CustomisePackageItenaryPojoResponse extends AbstractPojoResponse{

	private CustomisedOrderPackageIteneryPojo customisePackageIteneryPojo;

	public CustomisedOrderPackageIteneryPojo getCustomisePackageIteneryPojo() {
		return customisePackageIteneryPojo;
	}

	public void setCustomisePackageIteneryPojo(CustomisedOrderPackageIteneryPojo customisePackageIteneryPojo) {
		this.customisePackageIteneryPojo = customisePackageIteneryPojo;
	}
	
}
