package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerPaymentHistoryPojo;

public class CustomerPaymentHistoryListPojoResponse  extends AbstractPojoResponse{
	
	private List<CustomerPaymentHistoryPojo> customerPaymentHistoryPojo;

	public List<CustomerPaymentHistoryPojo> getCustomerPaymentHistoryPojo() {
		return customerPaymentHistoryPojo;
	}

	public void setCustomerPaymentHistoryPojo(List<CustomerPaymentHistoryPojo> customerPaymentHistoryPojo) {
		this.customerPaymentHistoryPojo = customerPaymentHistoryPojo;
	}

	
	
	
	
	

}
