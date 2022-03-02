package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.BtoBPaymentHistoryPojo;

public class BtoBPaymentHistoryPojoResponse  extends AbstractPojoResponse{
	private BtoBPaymentHistoryPojo bPaymentHistoryPojo;

	public BtoBPaymentHistoryPojo getbPaymentHistoryPojo() {
		return bPaymentHistoryPojo;
	}

	public void setbPaymentHistoryPojo(BtoBPaymentHistoryPojo bPaymentHistoryPojo) {
		this.bPaymentHistoryPojo = bPaymentHistoryPojo;
	}
	
	

}
