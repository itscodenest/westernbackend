package com.tour.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.tour.entity.DurationPackageSuggest;
import com.tour.pojo.DurationPackageSuggestPojo;
import com.tour.response.DurationPackageSuggestResponse;
import com.tour.response.DurationSuggestPackageListResponse;
import com.tour.response.ResponseMessagePojo;
import com.tour.service.DurationPackageSuggestService;
import com.tour.util.ObjectMapperUtils;

@Component
public class DurationPackageSuggestFacade {
	
	@Autowired
	DurationPackageSuggestService durationService;

	public DurationPackageSuggestResponse create(DurationPackageSuggestPojo durationPojo) {
		DurationPackageSuggest duration = ObjectMapperUtils.map(durationPojo, DurationPackageSuggest.class);
		duration = durationService.create(duration);
		durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		return createDeleteUpdateResponse(durationPojo, "Created successfully");
	}

	private DurationPackageSuggestResponse createDeleteUpdateResponse(DurationPackageSuggestPojo durationPojo, String message) {
		DurationPackageSuggestResponse durationPojoResponse = new DurationPackageSuggestResponse();
		List<ResponseMessagePojo> successMessaages = new ArrayList<>();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		responseMessagePojo.setSuccessMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessaages.add(responseMessagePojo);
		durationPojoResponse.setDurationPojo(durationPojo);
		durationPojoResponse.setSuccessMessaages(successMessaages);
		return durationPojoResponse;
	}

	public DurationPackageSuggestResponse get(long id) {
		DurationPackageSuggestResponse durationPojoResponse = new DurationPackageSuggestResponse();
		DurationPackageSuggest duration = durationService.getById(id);
		DurationPackageSuggestPojo durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		durationPojoResponse.setDurationPojo(durationPojo);
		return durationPojoResponse;
	}

	public DurationSuggestPackageListResponse listAll() {
		DurationSuggestPackageListResponse durationPojoListResponse = new DurationSuggestPackageListResponse();
		List<DurationPackageSuggest> duration = durationService.listAll();
		List<DurationPackageSuggestPojo> durationPojo = ObjectMapperUtils.mapAll(duration,
				DurationPackageSuggestPojo.class);
		durationPojoListResponse.setDurationPojo(durationPojo);
		return durationPojoListResponse;
	}

	public DurationPackageSuggestResponse delete(long id) {
		durationService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public DurationPackageSuggestResponse update(DurationPackageSuggestPojo durationPojo) {
		DurationPackageSuggest duration = durationService.getById(durationPojo.getId());
		ObjectMapperUtils.map(durationPojo, duration);
		duration = durationService.Update(duration);
		durationPojo = ObjectMapperUtils.map(duration, DurationPackageSuggestPojo.class);
		return createDeleteUpdateResponse(durationPojo, "Updated successfully");
	}

	
}
