package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.PackageSuggestPojo;

public class PackageSuggestPojoListResponse extends AbstractPojoResponse {
	
	List<PackageSuggestPojo> packageSuggestPojo;

	public List<PackageSuggestPojo> getPackageSuggestPojo() {
		return packageSuggestPojo;
	}

	public void setPackageSuggestPojo(List<PackageSuggestPojo> packageSuggestPojo) {
		this.packageSuggestPojo = packageSuggestPojo;
	}
	

}
