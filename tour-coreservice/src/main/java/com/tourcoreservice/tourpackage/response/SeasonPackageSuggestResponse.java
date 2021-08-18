package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestResponse extends AbstractPojoResponse{
	SeasonPackageSuggestPojo seasonPojo;

	public SeasonPackageSuggestPojo getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(SeasonPackageSuggestPojo seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	

}
