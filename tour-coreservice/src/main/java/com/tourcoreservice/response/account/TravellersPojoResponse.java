package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.TravellersPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class TravellersPojoResponse extends AbstractPojoResponse{
	
	TravellersPojo tPojo;

	public TravellersPojo gettPojo() {
		return tPojo;
	}

	public void settPojo(TravellersPojo tPojo) {
		this.tPojo = tPojo;
	}

}
