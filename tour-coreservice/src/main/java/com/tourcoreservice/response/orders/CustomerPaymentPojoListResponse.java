package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerPaymentPojo;

public class CustomerPaymentPojoListResponse extends AbstractPojoResponse{
	
	private List<CustomerPaymentPojo> customerPaymentPojos;

	public List<CustomerPaymentPojo> getCustomerPaymentPojos() {
		return customerPaymentPojos;
	}

	public void setCustomerPaymentPojos(List<CustomerPaymentPojo> customerPaymentPojos) {
		this.customerPaymentPojos = customerPaymentPojos;
		
	}
	
	
	

}
