package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageHotelInfoPojo;

public class CustomisePackageHotelInfoPojoListResponse extends AbstractPojoResponse{

	private List<CustomisedOrderPackageHotelInfoPojo> customisePackageHotelInfoPojo;

	public List<CustomisedOrderPackageHotelInfoPojo> getCustomisePackageHotelInfoPojo() {
		return customisePackageHotelInfoPojo;
	}

	public void setCustomisePackageHotelInfoPojo(List<CustomisedOrderPackageHotelInfoPojo> customisePackageHotelInfoPojo) {
		this.customisePackageHotelInfoPojo = customisePackageHotelInfoPojo;
	}
	
}
