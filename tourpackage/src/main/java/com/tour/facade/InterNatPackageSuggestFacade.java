package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tour.entity.InterNatPackageSuggest;
import com.tour.entity.Iternery;
import com.tour.entity.PackageSuggest;
import com.tour.pojo.InterNatPackageSuggestPojo;
import com.tour.pojo.IterneryPojo;
import com.tour.pojo.PackageSuggestPojo;
import com.tour.response.InterNatPackageSuggestListResponse;
import com.tour.response.InterNatPackageSuggestResponse;
import com.tour.response.IterneryPojoListResponse;
import com.tour.service.InterNatPackageSuggestService;
import com.tour.util.ObjectMapperUtils;

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
