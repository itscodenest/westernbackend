package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.SeasonPackageSuggestPojo;

public class SeasonPackageSuggestListResponse extends AbstractPojoResponse {
	List<SeasonPackageSuggestPojo> seasonPojo;

	public List<SeasonPackageSuggestPojo> getSeasonPojo() {
		return seasonPojo;
	}

	public void setSeasonPojo(List<SeasonPackageSuggestPojo> seasonPojo) {
		this.seasonPojo = seasonPojo;
	}
	
	

}
