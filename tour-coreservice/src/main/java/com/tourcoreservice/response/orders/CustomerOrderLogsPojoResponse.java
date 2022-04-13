package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerOrderLogsPojo;

public class CustomerOrderLogsPojoResponse extends AbstractPojoResponse{
	
	private CustomerOrderLogsPojo cPojo;

	public CustomerOrderLogsPojo getcPojo() {
		return cPojo;
	}

	public void setcPojo(CustomerOrderLogsPojo cPojo) {
		this.cPojo = cPojo;
	}
	
	

}
