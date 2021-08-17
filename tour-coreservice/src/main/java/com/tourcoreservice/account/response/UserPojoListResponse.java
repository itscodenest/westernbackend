package com.tourcoreservice.account.response;

import java.util.List;

import com.tourcoreservice.account.pojo.UserPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class UserPojoListResponse extends AbstractPojoResponse{
	List<UserPojo> userPojo;

	public List<UserPojo> getUserPojo() {
		return userPojo;
	}

	public void setUserPojo(List<UserPojo> userPojo) {
		this.userPojo = userPojo;
	}
	
	

}
