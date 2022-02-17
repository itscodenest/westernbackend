package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.SeasonPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.SeasonPackageSuggest;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.SeasonPackageSuggestPojo;
import com.tourcoreservice.response.tourpackage.SeasonPackageSuggestPojoListResponse;
import com.tourcoreservice.response.tourpackage.SeasonPackageSuggestPojoResponse;

@Component
public class SeasonPackageSuggestFacade {
	
	@Autowired
	SeasonPackageSuggestService seasonService;

	public SeasonPackageSuggestPojoResponse create(SeasonPackageSuggestPojo seasonPojo) {
		ifDataAlredyExits(seasonPojo.getId());
		SeasonPackageSuggest season = ObjectMapperUtils.map(seasonPojo, SeasonPackageSuggest.class);
		season = seasonService.create(season);
		seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
		return createDeleteUpdateResponse(seasonPojo, "Created successfully");
	}

	private void ifDataAlredyExits(long id) {
		SeasonPackageSuggest packageSuggest = seasonService.getById(id);
		if (!ObjectUtils.isEmpty(packageSuggest)) {
			throw new DataAlreadyExistException("Data already exists");
		}

	}

	private SeasonPackageSuggestPojoResponse createDeleteUpdateResponse(SeasonPackageSuggestPojo seasonPojo,
			String message) {
		SeasonPackageSuggestPojoResponse seasonPojoResponse = new SeasonPackageSuggestPojoResponse();	
		List<ResponseMessagePojo> successMessaages=new ArrayList<>();
		ResponseMessagePojo  responseMessagePojo= new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		seasonPojoResponse.setSuccessMessaages(successMessaages);
		return seasonPojoResponse;
	}
	public SeasonPackageSuggestPojoResponse get(long id) {
		ifDataDoesNotExist(id);
		SeasonPackageSuggestPojoResponse seasonPojoResponse = new SeasonPackageSuggestPojoResponse();
		SeasonPackageSuggest season = seasonService.getById(id);
		SeasonPackageSuggestPojo seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
		seasonPojoResponse.setSeasonPojo(seasonPojo);
		return seasonPojoResponse;
	}

	private void ifDataDoesNotExist(long id) {
		SeasonPackageSuggest packageSuggest = seasonService.getById(id);
		if (ObjectUtils.isEmpty(packageSuggest)) {
			throw new DataDoesNotExistException("Data doesn't exists");
		}

	}

	public SeasonPackageSuggestPojoListResponse listAll() {
		SeasonPackageSuggestPojoListResponse seasonPojoListResponse = new SeasonPackageSuggestPojoListResponse();
				List<SeasonPackageSuggest> season = seasonService.listAll();
				List<SeasonPackageSuggestPojo> seasonPojo = ObjectMapperUtils.mapAll(season, SeasonPackageSuggestPojo.class);
				seasonPojoListResponse.setSeasonPojo(seasonPojo);
				return seasonPojoListResponse;
			}
	public SeasonPackageSuggestPojoResponse delete(long id) {
		ifDataDoesNotExist(id);
		SeasonPackageSuggest season = seasonService.getById(id);
		seasonService.delete(season);
		return createDeleteUpdateResponse(null,"Deleted successfully");
		
	}
	public SeasonPackageSuggestPojoResponse update(SeasonPackageSuggestPojo seasonPojo) {
		ifDataDoesNotExist(seasonPojo.getId());
		SeasonPackageSuggest season = ObjectMapperUtils.map(seasonPojo, SeasonPackageSuggest.class);
		season = seasonService.Update(season);
		seasonPojo = ObjectMapperUtils.map(season, SeasonPackageSuggestPojo.class);
		return createDeleteUpdateResponse(seasonPojo, "Updated successfully");
	}

	
}
