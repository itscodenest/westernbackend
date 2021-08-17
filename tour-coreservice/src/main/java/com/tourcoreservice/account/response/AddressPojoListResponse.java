package com.tourcoreservice.account.response;

import java.util.List;

import com.tourcoreservice.account.pojo.AddressPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class AddressPojoListResponse extends AbstractPojoResponse {
	public List<AddressPojo> addressPojo;

	public List<AddressPojo> getAddressPojo() {
		return addressPojo;
	}

	public void setAddressPojo(List<AddressPojo> addressPojo) {
		this.addressPojo = addressPojo;
	}

	

}
