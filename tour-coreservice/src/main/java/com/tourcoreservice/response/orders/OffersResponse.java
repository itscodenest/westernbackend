package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.OffersPojo;

public class OffersResponse extends AbstractPojoResponse{
	
	private OffersPojo offersPojo;

	public OffersPojo getOffersPojo() {
		return offersPojo;
	}

	public void setOffersPojo(OffersPojo offersPojo) {
		this.offersPojo = offersPojo;
	}
	
	
}
