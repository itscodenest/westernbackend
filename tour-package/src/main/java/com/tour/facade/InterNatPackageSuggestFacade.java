package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tour.service.InterNatPackageSuggestService;
import com.tour.util.ObjectMapperUtils;
import com.tourcoreservice.entity.InterNatPackageSuggest;
import com.tourcoreservice.tourpackage.pojo.InterNatPackageSuggestPojo;
import com.tourcoreservice.tourpackage.response.InterNatPackageSuggestListResponse;
import com.tourcoreservice.tourpackage.response.InterNatPackageSuggestResponse;

@Component
public class InterNatPackageSuggestFacade {

	@Autowired
	InterNatPackageSuggestService interNatPackageSuggestService;

	public InterNatPackageSuggestResponse create(InterNatPackageSuggestPojo packageSuggestPojo) {
		InterNatPackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, InterNatPackageSuggest.class);
		packageSuggest = interNatPackageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, InterNatPackageSuggestPojo.class);
		InterNatPackageSuggestResponse packageSuggestPojoResponse = new InterNatPackageSuggestResponse();
		packageSuggestPojoResponse.setInterNatPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	public InterNatPackageSuggestListResponse getAll() {
		InterNatPackageSuggestListResponse PackagePojoListResponse = new InterNatPackageSuggestListResponse();
		List<InterNatPackageSuggest> packList = interNatPackageSuggestService.getAll();
		List<InterNatPackageSuggestPojo> PackagePojoList = ObjectMapperUtils.mapAll(packList,
				InterNatPackageSuggestPojo.class);
		PackagePojoListResponse.setInterNatPackageSuggestPojo(PackagePojoList);
		return PackagePojoListResponse;

	}

	public void delete(long id) {
		interNatPackageSuggestService.delete(id);

	}

	public InterNatPackageSuggestResponse update(InterNatPackageSuggestPojo packageSuggestPojo) {
		InterNatPackageSuggest interNatPackageSuggest = ObjectMapperUtils.map(packageSuggestPojo,
				InterNatPackageSuggest.class);
		interNatPackageSuggest = interNatPackageSuggestService.Update(interNatPackageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(interNatPackageSuggest, InterNatPackageSuggestPojo.class);
		InterNatPackageSuggestResponse packageSuggestPojoResponse = new InterNatPackageSuggestResponse();
		return packageSuggestPojoResponse;
	}

}
