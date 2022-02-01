package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.tour.service.CountryServices;
import com.tour.service.RegionService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.Country;
import com.tourcoreservice.entity.Regions;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.exception.tourpackage.DataDoesNotExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.tourpackage.CountryPojo;
import com.tourcoreservice.pojo.tourpackage.RegionPojo;
import com.tourcoreservice.response.tourpackage.CountryPojoListResponse;
import com.tourcoreservice.response.tourpackage.CountryPojoResponse;

@Component
public class CountryFacade {

	@Autowired
	private CountryServices countryService;

	@Autowired
	private RegionService regionService;
	
	public CountryPojoResponse saveCountry(CountryPojo country) {
		ifCountryExist(country.getName());
		ifRegionDoesNotExist(country.getRegion());
		Country countryEntity = ObjectMapperUtils.map(country, Country.class);
		Country countryServiceEntity = countryService.saveCountry(countryEntity);
		CountryPojo countryPojo = ObjectMapperUtils.map(countryServiceEntity, CountryPojo.class);
		return createDeleteUpdateResponse(countryPojo, "Created successfully");
	}

	private void ifRegionDoesNotExist(RegionPojo region) {
		Regions regions = regionService.findRegionById(region.getId());
		if(!ObjectUtils.isEmpty(regions)) {
			throw new DataAlreadyExistException("Data already exists");
		}
		
	}

	private void ifCountryExist(String name) {
		// TODO Auto-generated method stub

		Country country = countryService.findCountryByName(name);
		if (!ObjectUtils.isEmpty(country)) {
			throw new DataAlreadyExistException("Data already exists");
		}
	}

	public CountryPojoListResponse listAllCountries() {
		CountryPojoListResponse countryPojoListResponse = new CountryPojoListResponse();
		List<Country> country = countryService.listAllCountries();
		List<CountryPojo> countryPojo = ObjectMapperUtils.mapAll(country, CountryPojo.class);
		countryPojoListResponse.setCountryPojo(countryPojo);
		return countryPojoListResponse;
	}

	public CountryPojoResponse getCountry(Long id) {
		ifCountryDoesNotExist(id);
		CountryPojoResponse countryResponse = new CountryPojoResponse();
		Country countryEntity = countryService.getCountryById(id);
		CountryPojo countryPojo = ObjectMapperUtils.map(countryEntity, CountryPojo.class);
		countryResponse.setCountryPojo(countryPojo);
		return countryResponse;
	}
	
	private void ifCountryDoesNotExist(long id) {
		Country country = countryService.getCountryById(id);
		if (ObjectUtils.isEmpty(country)) {
			throw new DataDoesNotExistException("Data doesn't exsits");
		}

	}


	public CountryPojoResponse updateCountry(CountryPojo countryPojo) {
		ifCountryDoesNotExist(countryPojo.getId());
		Country country = countryService.getCountryById(countryPojo.getId());
		if (!ObjectUtils.isEmpty(country.getRegion())) {
			deleteExistingStates(country, country.getRegion());
		}

		ObjectMapperUtils.map(countryPojo, country);
		country = countryService.updateCountry(country);
		countryPojo = ObjectMapperUtils.map(country, CountryPojo.class);
		return createDeleteUpdateResponse(countryPojo, "Updated successfully");
	}

	private void deleteExistingStates(Country country, Regions regions) {
		regions = null;
		country.setRegion(regions);
		countryService.save(country);

	}

	public CountryPojoResponse deleteCountry(long id) {
		ifCountryDoesNotExist(id);
		countryService.deleteCountry(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	private CountryPojoResponse createDeleteUpdateResponse(CountryPojo countryPojo, String message) {
		CountryPojoResponse countryPojoResponse = new CountryPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		countryPojoResponse.setCountryPojo(countryPojo);
		countryPojoResponse.setSuccessMessaages(successMessages);
		return countryPojoResponse;
	}
}
