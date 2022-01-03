package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageHotelInfoPojo;

public class CustomisePackageHotelInfoPojoResponse extends AbstractPojoResponse {

	private CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo;

	public CustomisedOrderPackageHotelInfoPojo getCustomisePackageHotelInfoPojo() {
		return customisePackageHotelInfoPojo;
	}

	public void setCustomisePackageHotelInfoPojo(CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo) {
		this.customisePackageHotelInfoPojo = customisePackageHotelInfoPojo;
	}
	
}
