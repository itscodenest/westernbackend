package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.PrivilegePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class PrivilegePojoResponse extends AbstractPojoResponse{
	PrivilegePojo privilegePojo;

	public PrivilegePojo getPrivilegePojo() {
		return privilegePojo;
	}

	public void setPrivilegePojo(PrivilegePojo privilegePojo) {
		this.privilegePojo = privilegePojo;
	}
	

}
