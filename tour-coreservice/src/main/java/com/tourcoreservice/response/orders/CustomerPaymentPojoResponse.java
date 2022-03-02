package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerPaymentPojo;

public class CustomerPaymentPojoResponse extends AbstractPojoResponse{

	private CustomerPaymentPojo customerPaymentPojo;

	public CustomerPaymentPojo getCustomerPaymentPojo() {
		return customerPaymentPojo;
	}

	public void setCustomerPaymentPojo(CustomerPaymentPojo customerPaymentPojo) {
		this.customerPaymentPojo = customerPaymentPojo;
	}

}
