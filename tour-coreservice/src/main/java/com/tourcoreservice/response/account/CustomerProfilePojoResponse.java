package com.tourcoreservice.response.account;

import com.tourcoreservice.pojo.account.CustomerProfilePojo;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;

public class CustomerProfilePojoResponse  extends AbstractPojoResponse{
	
	private CustomerProfilePojo cPojo;

	public CustomerProfilePojo getcPojo() {
		return cPojo;
	}

	public void setcPojo(CustomerProfilePojo cPojo) {
		this.cPojo = cPojo;
	}
	
	

}
