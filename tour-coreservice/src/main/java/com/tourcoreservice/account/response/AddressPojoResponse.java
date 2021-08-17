package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.AddressPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class AddressPojoResponse extends AbstractPojoResponse {

	public AddressPojo addressPojo;

	public AddressPojo getAddressPojo() {
		return addressPojo;
	}

	public void setAddressPojo(AddressPojo addressPojo) {
		this.addressPojo = addressPojo;
	}

}
