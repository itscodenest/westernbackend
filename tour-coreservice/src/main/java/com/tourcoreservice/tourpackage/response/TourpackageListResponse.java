package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.TourPackagePartialPojo;

public class TourpackageListResponse {
	List<TourPackagePartialPojo> tourpackagePojo;

	public List<TourPackagePartialPojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourPackagePartialPojo> tourPackagePojo2) {
		this.tourpackagePojo = tourPackagePojo2;
	}
	

}
