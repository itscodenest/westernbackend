package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.SeasonPackageSuggest;
import com.tour.pojo.SeasonPackageSuggestPojo;
import com.tour.response.ResponseMessagePojo;
import com.tour.response.SeasonPackageSuggestListResponse;
import com.tour.response.SeasonPackageSuggestResponse;
import com.tour.service.SeasonPackageSuggestService;
import com.tour.util.ObjectMapperUtils;

@Component
public class SeasonPackageSuggestFacade {
	
	@Autowired
	SeasonPackageSuggestService seasonService;

	public SeasonPackageSuggestResponse create(SeasonPackageSuggestPojo seasonPojo) {
			SeasonPackageSuggest season = ObjectMapperUtils.map(seasonPojo, SeasonPackageSuggest.class);
			season = seasonService.create(season);
			seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
			return createDeleteUpdateResponse(seasonPojo,"Created successfully");
	}
	private SeasonPackageSuggestResponse createDeleteUpdateResponse(SeasonPackageSuggestPojo seasonPojo,
			String message) {
		SeasonPackageSuggestResponse seasonPojoResponse = new SeasonPackageSuggestResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		seasonPojoResponse.setSuccessMessaages(successMessaages);
		return seasonPojoResponse;
	}
	public SeasonPackageSuggestResponse get(long id) {
		SeasonPackageSuggestResponse seasonPojoResponse = new SeasonPackageSuggestResponse();
		SeasonPackageSuggest season = seasonService.getById(id);
		SeasonPackageSuggestPojo seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		return seasonPojoResponse;
		}
	public SeasonPackageSuggestListResponse listAll() {
		SeasonPackageSuggestListResponse seasonPojoListResponse = new SeasonPackageSuggestListResponse();
				List<SeasonPackageSuggest> season = seasonService.listAll();
				List<SeasonPackageSuggestPojo> seasonPojo = ObjectMapperUtils.mapAll(season, SeasonPackageSuggestPojo.class);
				seasonPojoListResponse.setSeasonPojo(seasonPojo);
				return seasonPojoListResponse;
			}
	public SeasonPackageSuggestResponse delete(long id) {
		SeasonPackageSuggest season = seasonService.getById(id);
		seasonService.delete(season);
		return createDeleteUpdateResponse(null,"Deleted successfully");
		
	}
	public SeasonPackageSuggestResponse update(SeasonPackageSuggestPojo seasonPojo) {
			SeasonPackageSuggest season = ObjectMapperUtils.map(seasonPojo, SeasonPackageSuggest.class);
			season = seasonService.Update(season);
			seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
				return createDeleteUpdateResponse(seasonPojo,"Updated successfully");
			}
	

	
}
