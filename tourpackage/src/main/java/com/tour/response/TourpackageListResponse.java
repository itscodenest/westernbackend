package com.tour.response;

import java.util.List;

import com.tour.pojo.TourPackagePartialPojo;
import com.tour.pojo.TourpackagePojo;

public class TourpackageListResponse {
	List<TourPackagePartialPojo> tourpackagePojo;

	public List<TourPackagePartialPojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourPackagePartialPojo> tourPackagePojo2) {
		this.tourpackagePojo = tourPackagePojo2;
	}
	

}
