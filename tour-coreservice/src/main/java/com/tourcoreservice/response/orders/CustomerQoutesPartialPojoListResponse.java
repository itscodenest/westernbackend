package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.orders.CustomerQoutesPartialPojo;

public class CustomerQoutesPartialPojoListResponse {

	private List<CustomerQoutesPartialPojo> cPojos;

	public List<CustomerQoutesPartialPojo> getcPojos() {
		return cPojos;
	}

	public void setcPojos(List<CustomerQoutesPartialPojo> cPojos) {
		this.cPojos = cPojos;
	}
	
	
}
