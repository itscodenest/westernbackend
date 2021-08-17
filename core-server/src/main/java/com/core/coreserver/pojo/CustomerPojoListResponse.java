package com.core.coreserver.pojo;

import java.util.List;

import com.tourcoreservice.account.pojo.CustomerPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class CustomerPojoListResponse extends AbstractPojoResponse {

	List<CustomerPojo> customerPojo;

	public List<CustomerPojo> getCustomerPojo() {
		return customerPojo;
	}

	public void setCustomerPojo(List<CustomerPojo> customerPojo) {
		this.customerPojo = customerPojo;
	}

}
