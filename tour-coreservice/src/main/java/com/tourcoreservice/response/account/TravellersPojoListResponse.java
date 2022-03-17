package com.tourcoreservice.response.account;

import java.util.List;

import com.tourcoreservice.pojo.account.TravellersPojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class TravellersPojoListResponse extends AbstractPojoResponse{
	
	public List<TravellersPojo> tPojos;

	public List<TravellersPojo> gettPojos() {
		return tPojos;
	}

	public void settPojos(List<TravellersPojo> tPojos) {
		this.tPojos = tPojos;
	}
	
	

}
