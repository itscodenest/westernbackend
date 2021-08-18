package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.DurationPackageSuggestPojo;

public class DurationPackageSuggestResponse extends AbstractPojoResponse{
	DurationPackageSuggestPojo durationPojo;

	public DurationPackageSuggestPojo getDurationPojo() {
		return durationPojo;
	}

	public void setDurationPojo(DurationPackageSuggestPojo durationPojo) {
		this.durationPojo = durationPojo;
	}

	


}
