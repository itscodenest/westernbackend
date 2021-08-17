package com.tourcoreservice.account.response;

import java.util.List;

import com.tourcoreservice.account.pojo.RolePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class RolePojoListResponse extends AbstractPojoResponse {
	List<RolePojo> rolePojoList;

	public List<RolePojo> getRolePojoList() {
		return rolePojoList;
	}

	public void setRolePojoList(List<RolePojo> rolePojoList) {
		this.rolePojoList = rolePojoList;
	}

}
