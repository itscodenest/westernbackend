package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.PackageSuggestPojo;

public class PackageSuggestPojoResponse extends AbstractPojoResponse{
	
	PackageSuggestPojo packageSuggestPojo;

	public PackageSuggestPojo getPackageSuggestPojo() {
		return packageSuggestPojo;
	}

	public void setPackageSuggestPojo(PackageSuggestPojo packageSuggestPojo) {
		this.packageSuggestPojo = packageSuggestPojo;
	}
	
	

}
