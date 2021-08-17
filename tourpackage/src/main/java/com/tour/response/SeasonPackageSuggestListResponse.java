package com.tour.response;

import java.util.List;

import com.tour.pojo.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestListResponse extends AbstractPojoResponse {
	List<SeasonPackageSuggestPojo> seasonPojo;

	public List<SeasonPackageSuggestPojo> getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(List<SeasonPackageSuggestPojo> seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	
	

}
