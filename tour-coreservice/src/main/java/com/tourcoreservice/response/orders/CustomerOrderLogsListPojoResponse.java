package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.orders.CustomerOrderLogsPojo;

public class CustomerOrderLogsListPojoResponse {
	
	private List<CustomerOrderLogsPojo> cList;

	public List<CustomerOrderLogsPojo> getcList() {
		return cList;
	}

	public void setcList(List<CustomerOrderLogsPojo> cList) {
		this.cList = cList;
	}
	
	
}
