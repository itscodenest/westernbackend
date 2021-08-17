package com.tourcoreservice.account.response;

import com.tourcoreservice.account.pojo.UserPojo;
import com.tourcoreservice.generic.pojo.AbstractPojoResponse;

public class UserPojoResponse extends AbstractPojoResponse{
	
	UserPojo userPojo;

	public UserPojo getUserPojo() {
		return userPojo;
	}

	public void setUserPojo(UserPojo userPojo) {
		this.userPojo = userPojo;
	}

	public void setAddressPojo(UserPojo userPojo2) {
		// TODO Auto-generated method stub
		
	}
	

}
