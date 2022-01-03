package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageFlightinfoPojo;

public class CustomisePackageFlightinfoPojoListResponse extends AbstractPojoResponse{

	private List<CustomisedOrderPackageFlightinfoPojo> customisePackageFlightinfoPojo;

	public List<CustomisedOrderPackageFlightinfoPojo> getCustomisePackageFlightinfoPojo() {
		return customisePackageFlightinfoPojo;
	}

	public void setCustomisePackageFlightinfoPojo(List<CustomisedOrderPackageFlightinfoPojo> customisePackageFlightinfoPojo) {
		this.customisePackageFlightinfoPojo = customisePackageFlightinfoPojo;
	}
	
}
