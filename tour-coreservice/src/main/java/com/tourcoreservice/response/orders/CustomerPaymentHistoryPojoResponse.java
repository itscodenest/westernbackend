package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerPaymentHistoryPojo;

public class CustomerPaymentHistoryPojoResponse extends AbstractPojoResponse {
	private CustomerPaymentHistoryPojo customerPaymentHistory;

	public CustomerPaymentHistoryPojo getCustomerPaymentHistory() {
		return customerPaymentHistory;
	}

	public void setCustomerPaymentHistory(CustomerPaymentHistoryPojo customerPaymentHistory) {
		this.customerPaymentHistory = customerPaymentHistory;
	}
	

}
