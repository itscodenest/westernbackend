package com.tour.response;

import java.util.List;

import com.tour.pojo.HotelPartialPojo;
import com.tour.pojo.HotelPojo;

public class HotelListResponse extends AbstractPojoResponse{

	List<HotelPartialPojo> hotelPojo;

	public List<HotelPartialPojo> getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(List<HotelPartialPojo> hotelPojo) {
		this.hotelPojo = hotelPojo;
	}

	
	
}
