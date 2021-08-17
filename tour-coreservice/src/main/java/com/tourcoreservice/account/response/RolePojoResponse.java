package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.RolePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class RolePojoResponse extends AbstractPojoResponse {

	RolePojo rolePojo;

	public RolePojo getRolePojo() {
		return rolePojo;
	}

	public void setRolePojo(RolePojo rolePojo) {
		this.rolePojo = rolePojo;
	}

}
