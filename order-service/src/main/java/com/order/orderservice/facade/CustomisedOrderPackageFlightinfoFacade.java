package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisedOrderPackageFlightinfoService;
import com.tourcoreservice.entity.CustomisedOrderPackageFlightinfo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageFlightinfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageFlightinfoPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisedOrderPackageFlightinfoFacade {

	@Autowired
	private CustomisedOrderPackageFlightinfoService customisePackageFlightinfoService;

	public CustomisePackageFlightinfoPojoResponse create(
			CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo) {
		CustomisedOrderPackageFlightinfo customisePackageFlightinfo = ObjectMapperUtils.map(customisePackageFlightinfoPojo,
				CustomisedOrderPackageFlightinfo.class);
		customisePackageFlightinfo = customisePackageFlightinfoService.create(customisePackageFlightinfo);
		customisePackageFlightinfoPojo = ObjectMapperUtils.map(customisePackageFlightinfo,
				CustomisedOrderPackageFlightinfoPojo.class);
		return createDeleteUpdateResponse(customisePackageFlightinfoPojo, "Customised package created Successfully ");
	}

	private CustomisePackageFlightinfoPojoResponse createDeleteUpdateResponse(
			CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo, String message) {

		CustomisePackageFlightinfoPojoResponse customisedPackageFlightinfoPojoResponse = new CustomisePackageFlightinfoPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisedPackageFlightinfoPojoResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		customisedPackageFlightinfoPojoResponse.setSuccessMessaages(successMessages);
		return customisedPackageFlightinfoPojoResponse;
	}

	public CustomisePackageFlightinfoPojoListResponse listAll() {
		CustomisePackageFlightinfoPojoListResponse customisePackageFlightinfoPojoListResponse = new CustomisePackageFlightinfoPojoListResponse();
		List<CustomisedOrderPackageFlightinfo> customisePackageFlightinfo = customisePackageFlightinfoService.listAll();
		List<CustomisedOrderPackageFlightinfoPojo> customisePackageFlightinfoPojo = ObjectMapperUtils
				.mapAll(customisePackageFlightinfo, CustomisedOrderPackageFlightinfoPojo.class);
		customisePackageFlightinfoPojoListResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		return customisePackageFlightinfoPojoListResponse;
	}

	public CustomisePackageFlightinfoPojoResponse getDataByid(Long id) {
		CustomisePackageFlightinfoPojoResponse customisePackageFlightinfoPojoResponse = new CustomisePackageFlightinfoPojoResponse();
		CustomisedOrderPackageFlightinfo customisePackageFlightinfo = customisePackageFlightinfoService.getById(id);
		CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo = ObjectMapperUtils
				.map(customisePackageFlightinfo, CustomisedOrderPackageFlightinfoPojo.class);
		customisePackageFlightinfoPojoResponse.setCustomisePackageFlightinfoPojo(customisePackageFlightinfoPojo);
		return customisePackageFlightinfoPojoResponse;
	}

	public CustomisePackageFlightinfoPojoResponse delete(long id) {
		customisePackageFlightinfoService.deleteCustomisePackageFlightinfo(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageFlightinfoPojoResponse update(
			CustomisedOrderPackageFlightinfoPojo customisePackageFlightinfoPojo) {
		CustomisedOrderPackageFlightinfo customisePackageFlightinfo = customisePackageFlightinfoService
				.getById(customisePackageFlightinfoPojo.getId());
		ObjectMapperUtils.map(customisePackageFlightinfoPojo, customisePackageFlightinfo);
		customisePackageFlightinfo = customisePackageFlightinfoService.Update(customisePackageFlightinfo);
		customisePackageFlightinfoPojo = ObjectMapperUtils.map(customisePackageFlightinfo,
				CustomisedOrderPackageFlightinfoPojo.class);
		return createDeleteUpdateResponse(customisePackageFlightinfoPojo, "Updated successfully");
	}

}
