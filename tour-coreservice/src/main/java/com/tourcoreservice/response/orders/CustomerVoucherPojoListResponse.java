package com.tourcoreservice.response.orders;

import java.util.List;
import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerVouchersPojo;

public class CustomerVoucherPojoListResponse extends AbstractPojoResponse{
	private List<CustomerVouchersPojo> cList;

	public List<CustomerVouchersPojo> getcList() {
		return cList;
	}

	public void setcList(List<CustomerVouchersPojo> cPojos) {
		this.cList = cPojos;
	}
	
	

}
