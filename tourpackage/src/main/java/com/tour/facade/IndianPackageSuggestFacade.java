package com.tour.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.tour.entity.IndianPackageSuggest;
import com.tour.entity.InterNatPackageSuggest;
import com.tour.pojo.IndianPackageSuggestPojo;
import com.tour.pojo.InterNatPackageSuggestPojo;
import com.tour.response.IndianPackageSuggestListResponse;
import com.tour.response.IndianPackageSuggestResponse;
import com.tour.response.InterNatPackageSuggestResponse;
import com.tour.service.IndianPackageSuggestService;
import com.tour.util.ObjectMapperUtils;

@Component
public class IndianPackageSuggestFacade {
	
	@Autowired 
	IndianPackageSuggestService indianPackageSuggestService;

	public IndianPackageSuggestResponse create(IndianPackageSuggestPojo packageSuggestPojo) {
		IndianPackageSuggest packageSuggest = ObjectMapperUtils.map(packageSuggestPojo, IndianPackageSuggest.class);
		packageSuggest = indianPackageSuggestService.create(packageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(packageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestResponse packageSuggestPojoResponse = new IndianPackageSuggestResponse();
		packageSuggestPojoResponse.setIndianPackageSuggestPojo(packageSuggestPojo);
		return packageSuggestPojoResponse;
	}

	public IndianPackageSuggestListResponse getAll() {
		IndianPackageSuggestListResponse packageSuggestPojoResponse = new IndianPackageSuggestListResponse();
		List<IndianPackageSuggest> packList = indianPackageSuggestService.getAll();
		List<IndianPackageSuggestPojo> PackagePojoList = ObjectMapperUtils.mapAll(packList,
				IndianPackageSuggestPojo.class);
		packageSuggestPojoResponse.setIndianPackageSuggestPojos(PackagePojoList);
		return packageSuggestPojoResponse;
	}
	
	public void delete(long id) {
		indianPackageSuggestService.delete(id);

	}

	public IndianPackageSuggestResponse update(IndianPackageSuggestPojo packageSuggestPojo) {
		IndianPackageSuggest indianPackageSuggest = ObjectMapperUtils.map(packageSuggestPojo,
				IndianPackageSuggest.class);
		indianPackageSuggest = indianPackageSuggestService.Update(indianPackageSuggest);
		packageSuggestPojo = ObjectMapperUtils.map(indianPackageSuggest, IndianPackageSuggestPojo.class);
		IndianPackageSuggestResponse packageSuggestPojoResponse = new IndianPackageSuggestResponse();
		return packageSuggestPojoResponse;
	}

}
