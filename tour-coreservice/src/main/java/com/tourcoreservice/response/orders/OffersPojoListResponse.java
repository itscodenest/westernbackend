package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OffersPojo;

public class OffersPojoListResponse extends AbstractPojoResponse{

	private List<OffersPojo> offersPojos;

	public List<OffersPojo> getOffersPojos() {
		return offersPojos;
	}

	public void setOffersPojos(List<OffersPojo> offersPojos) {
		this.offersPojos = offersPojos;
	}

	

}
