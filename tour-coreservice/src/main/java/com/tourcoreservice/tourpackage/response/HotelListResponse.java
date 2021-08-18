package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.HotelPartialPojo;

public class HotelListResponse extends AbstractPojoResponse{

	List<HotelPartialPojo> hotelPojo;

	public List<HotelPartialPojo> getHotelPojo() {
		return hotelPojo;
	}

	public void setHotelPojo(List<HotelPartialPojo> hotelPojo) {
		this.hotelPojo = hotelPojo;
	}

	
	
}
