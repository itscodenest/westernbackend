package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackagePojo;

public class CustomisePackagePojoRespone extends AbstractPojoResponse{

	private CustomisedOrderPackagePojo customisePackagePojo;

	public CustomisedOrderPackagePojo getCustomisePackagePojo() {
		return customisePackagePojo;
	}

	public void setCustomisePackagePojo(CustomisedOrderPackagePojo customisePackagePojo) {
		this.customisePackagePojo = customisePackagePojo;
	}
	
}
