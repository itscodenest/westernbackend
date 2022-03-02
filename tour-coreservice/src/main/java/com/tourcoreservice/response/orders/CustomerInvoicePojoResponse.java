package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerInvoicePojo;

public class CustomerInvoicePojoResponse extends AbstractPojoResponse{
	
	private CustomerInvoicePojo cInvoicePojo;

	public CustomerInvoicePojo getcInvoicePojo() {
		return cInvoicePojo;
	}

	public void setcInvoicePojo(CustomerInvoicePojo cInvoicePojo) {
		this.cInvoicePojo = cInvoicePojo;
	}
	
	

}
