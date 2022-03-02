package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerInvoicePojo;

public class CustomerInvoicePojoListResponse extends AbstractPojoResponse {
	
	private List<CustomerInvoicePojo> cPojos;

	public List<CustomerInvoicePojo> getcPojos() {
		return cPojos;
	}

	public void setcPojos(List<CustomerInvoicePojo> cPojos) {
		this.cPojos = cPojos;
	}

	
	
}
