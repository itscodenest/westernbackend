package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.PlacePojo;



public class PlaceListResponse {

	List<PlacePojo> placePojos;

	public List<PlacePojo> getPlacePojos() {
		return placePojos;
	}

	public void setPlacePojos(List<PlacePojo> placePojos) {
		this.placePojos = placePojos;
	}
}
