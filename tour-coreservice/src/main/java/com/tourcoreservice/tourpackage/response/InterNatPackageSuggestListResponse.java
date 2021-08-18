package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.InterNatPackageSuggestPojo;

public class InterNatPackageSuggestListResponse {
 List<InterNatPackageSuggestPojo> interNatPackageSuggestPojo;

public List<InterNatPackageSuggestPojo> getInterNatPackageSuggestPojo() {
	return interNatPackageSuggestPojo;
}

public void setInterNatPackageSuggestPojo(List<InterNatPackageSuggestPojo> interNatPackageSuggestPojo) {
	this.interNatPackageSuggestPojo = interNatPackageSuggestPojo;
}
}
