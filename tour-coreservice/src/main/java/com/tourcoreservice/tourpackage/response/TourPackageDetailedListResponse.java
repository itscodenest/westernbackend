package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.TourpackagePojo;

public class TourPackageDetailedListResponse {
	List<TourpackagePojo> tourpackagePojo;

	public List<TourpackagePojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourpackagePojo> tourpackagePojo) {
		this.tourpackagePojo = tourpackagePojo;
	}
	
}
