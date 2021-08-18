package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.IndianPackageSuggestPojo;

public class IndianPackageSuggestListResponse {

	List<IndianPackageSuggestPojo> indianPackageSuggestPojos;

	public List<IndianPackageSuggestPojo> getIndianPackageSuggestPojos() {
		return indianPackageSuggestPojos;
	}

	public void setIndianPackageSuggestPojos(List<IndianPackageSuggestPojo> indianPackageSuggestPojos) {
		this.indianPackageSuggestPojos = indianPackageSuggestPojos;
	}
	
}
