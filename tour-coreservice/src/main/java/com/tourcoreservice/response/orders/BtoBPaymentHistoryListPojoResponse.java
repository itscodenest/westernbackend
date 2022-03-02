package com.tourcoreservice.response.orders;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.BtoBPaymentHistoryPojo;

public class BtoBPaymentHistoryListPojoResponse extends AbstractPojoResponse{

	private List<BtoBPaymentHistoryPojo> bPaymentHistoryPojo;
	

	public List<BtoBPaymentHistoryPojo> getbPaymentHistoryPojo() {
		return bPaymentHistoryPojo;
	}

	public void setbPaymentHistoryPojo(List<BtoBPaymentHistoryPojo> bPaymentHistoryPojo) {
		this.bPaymentHistoryPojo = bPaymentHistoryPojo;
	}
	
	
	
	
}
