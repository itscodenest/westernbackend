package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.CustomerPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class CustomerPojoResponse extends AbstractPojoResponse {

	CustomerPojo customerPojo;

	public CustomerPojo getCustomerPojo() {
		return customerPojo;
	}

	public void setCustomerPojo(CustomerPojo customerPojo) {
		this.customerPojo = customerPojo;
	}

}
