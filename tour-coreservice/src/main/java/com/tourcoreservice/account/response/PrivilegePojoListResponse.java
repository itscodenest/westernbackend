package com.tourcoreservice.account.response;

import java.util.List;

import com.tourcoreservice.account.pojo.PrivilegePojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class PrivilegePojoListResponse extends AbstractPojoResponse {
	List<PrivilegePojo> privilegePojoList;

	public List<PrivilegePojo> getPrivilegePojoList() {
		return privilegePojoList;
	}

	public void setPrivilegePojoList(List<PrivilegePojo> privilegePojoList) {
		this.privilegePojoList = privilegePojoList;
	}

}
