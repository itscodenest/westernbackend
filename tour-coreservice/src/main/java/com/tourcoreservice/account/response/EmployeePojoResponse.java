package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.EmployeePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class EmployeePojoResponse extends AbstractPojoResponse {
	EmployeePojo employeePojo;

	public EmployeePojo getEmployeePojo() {
		return employeePojo;
	}

	public void setEmployeePojo(EmployeePojo employeePojo) {
		this.employeePojo = employeePojo;
	}

}
