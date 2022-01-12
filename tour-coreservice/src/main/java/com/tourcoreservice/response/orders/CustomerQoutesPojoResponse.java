package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerQoutesPojo;

public class CustomerQoutesPojoResponse extends AbstractPojoResponse{

	private CustomerQoutesPojo qoutesPojo;

	public CustomerQoutesPojo getQoutesPojo() {
		return qoutesPojo;
	}

	public void setQoutesPojo(CustomerQoutesPojo qoutesPojo) {
		this.qoutesPojo = qoutesPojo;
	}

	

	
}
