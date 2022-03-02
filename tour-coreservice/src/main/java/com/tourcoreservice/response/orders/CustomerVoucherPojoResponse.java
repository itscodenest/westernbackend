package com.tourcoreservice.response.orders;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.orders.CustomerVouchersPojo;

public class CustomerVoucherPojoResponse extends AbstractPojoResponse{
	private CustomerVouchersPojo cVoucher;

	public CustomerVouchersPojo getcVoucher() {
		return cVoucher;
	}

	public void setcVoucher(CustomerVouchersPojo cVouchersPojo) {
		this.cVoucher = cVouchersPojo;
	}
	
	

}
