package com.tourcoreservice.account.response;

import java.util.List;

import com.tourcoreservice.account.pojo.EmployeePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class EmployeePojoListResponse extends AbstractPojoResponse {

	List<EmployeePojo> emploeePojo;

	public List<EmployeePojo> getEmploeePojo() {
		return emploeePojo;
	}

	public void setEmploeePojo(List<EmployeePojo> emploeePojo) {
		this.emploeePojo = emploeePojo;
	}

}
