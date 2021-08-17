package com.tour.response;

import java.util.List;

import com.tour.pojo.TourPackagePartialPojo;
import com.tour.pojo.TourpackagePojo;

public class TourPackageDetailedListResponse {
	List<TourpackagePojo> tourpackagePojo;

	public List<TourpackagePojo> getTourpackagePojo() {
		return tourpackagePojo;
	}

	public void setTourpackagePojo(List<TourpackagePojo> tourpackagePojo) {
		this.tourpackagePojo = tourpackagePojo;
	}
	
}
