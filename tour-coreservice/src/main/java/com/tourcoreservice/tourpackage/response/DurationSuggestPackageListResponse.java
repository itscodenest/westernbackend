package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.DurationPackageSuggestPojo;

public class DurationSuggestPackageListResponse {

	List<DurationPackageSuggestPojo> durationPojo;

	public List<DurationPackageSuggestPojo> getDurationPojo() {
		return durationPojo;
	}

	public void setDurationPojo(List<DurationPackageSuggestPojo> durationPojo) {
		this.durationPojo = durationPojo;
	}

	

}
