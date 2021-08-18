package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.PlacePojo;

public class PlaceResponce extends AbstractPojoResponse {

	PlacePojo placePojo;

	public PlacePojo getPlacePojo() {
		return placePojo;
	}

	public void setPlacePojo(PlacePojo placePojo) {
		this.placePojo = placePojo;
	}
}
