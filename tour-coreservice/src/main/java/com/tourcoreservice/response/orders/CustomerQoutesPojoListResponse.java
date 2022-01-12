package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerQoutesPojo;

public class CustomerQoutesPojoListResponse extends AbstractPojoResponse {

	private List<CustomerQoutesPojo> cPojos;

	public List<CustomerQoutesPojo> getcPojos() {
		return cPojos;
	}

	public void setcPojos(List<CustomerQoutesPojo> cPojos) {
		this.cPojos = cPojos;
	}

	
}
