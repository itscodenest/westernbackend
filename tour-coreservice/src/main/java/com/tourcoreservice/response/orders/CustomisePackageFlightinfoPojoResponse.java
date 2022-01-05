package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageFlightinfoPojo;

public class CustomisePackageFlightinfoPojoResponse extends AbstractPojoResponse{

	private CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo;

	public CustomisedOrderPackageFlightinfoPojo getCustomisePackageFlightinfoPojo() {
		return customisePackageFlightinfoPojo;
	}

	public void setCustomisePackageFlightinfoPojo(CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo) {
		this.customisePackageFlightinfoPojo = customisePackageFlightinfoPojo;
	}
	
	
}
