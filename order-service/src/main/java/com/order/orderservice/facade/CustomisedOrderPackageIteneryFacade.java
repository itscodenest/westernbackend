package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisedOrderPackageIteneryService;
import com.tourcoreservice.entity.CustomisedOrderPackageIternery;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisedOrderPackageIteneryFacade {

	@Autowired
	private CustomisedOrderPackageIteneryService customisePackageItenaryService;

	public CustomisePackageItenaryPojoResponse createItenery(CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo) {
		CustomisedOrderPackageIternery customisePackageIternery = ObjectMapperUtils.map(customisePackageItenaryPojo,
				CustomisedOrderPackageIternery.class);
		customisePackageIternery = customisePackageItenaryService.create(customisePackageIternery);
		customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageIternery,
				CustomisedOrderPackageIteneryPojo.class);
		return createDeleteUpdateResponse(customisePackageItenaryPojo,
				"Customise package itenary created Successfully ");
	}

	private CustomisePackageItenaryPojoResponse createDeleteUpdateResponse(
			CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo, String message) {
		CustomisePackageItenaryPojoResponse customisePackageItenaryPojoResponse = new CustomisePackageItenaryPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackageItenaryPojoResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);

		customisePackageItenaryPojoResponse.setSuccessMessaages(successMessages);
		return customisePackageItenaryPojoResponse;
	}

	public CustomisePackageItenaryPojoListResponse listAll() {
		CustomisePackageItenaryPojoListResponse customisePackageItenaryPojoListResponse = new CustomisePackageItenaryPojoListResponse();
		List<CustomisedOrderPackageIternery> customisePackageItenary = customisePackageItenaryService.listAll();
		List<CustomisedOrderPackageIteneryPojo> customisePackageItenaryPojo = ObjectMapperUtils
				.mapAll(customisePackageItenary, CustomisedOrderPackageIteneryPojo.class);
		customisePackageItenaryPojoListResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);

		return customisePackageItenaryPojoListResponse;

	}

	public CustomisePackageItenaryPojoResponse getByid(Long id) {
		CustomisePackageItenaryPojoResponse customisePackageItenaryPojoResponse = new CustomisePackageItenaryPojoResponse();
		CustomisedOrderPackageIternery customisePackageItenary = customisePackageItenaryService.getById(id);
		CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageItenary,
				CustomisedOrderPackageIteneryPojo.class);
		customisePackageItenaryPojoResponse.setCustomisePackageIteneryPojo(customisePackageItenaryPojo);

		return customisePackageItenaryPojoResponse;
	}

	public CustomisePackageItenaryPojoResponse delete(long id) {
		customisePackageItenaryService.deleteItenary(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageItenaryPojoResponse update(CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo) {
		CustomisedOrderPackageIternery customisePackageIternery = customisePackageItenaryService
				.getById(customisePackageItenaryPojo.getId());
		ObjectMapperUtils.map(customisePackageItenaryPojo, customisePackageIternery);
		customisePackageIternery = customisePackageItenaryService.Update(customisePackageIternery);
		customisePackageItenaryPojo = ObjectMapperUtils.map(customisePackageIternery,
				CustomisedOrderPackageIteneryPojo.class);
		return createDeleteUpdateResponse(customisePackageItenaryPojo, "Updated successfully");
	}

	

}
