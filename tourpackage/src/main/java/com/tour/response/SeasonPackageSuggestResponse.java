package com.tour.response;

import com.tour.pojo.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestResponse extends AbstractPojoResponse{
	SeasonPackageSuggestPojo seasonPojo;

	public SeasonPackageSuggestPojo getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(SeasonPackageSuggestPojo seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	

}
