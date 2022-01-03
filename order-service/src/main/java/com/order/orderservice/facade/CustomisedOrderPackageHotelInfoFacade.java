package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisedOrderPackageHotelInfoService;
import com.tourcoreservice.entity.CustomisedOrderPackageHotelInfo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageHotelInfoPojo;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageHotelInfoPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisedOrderPackageHotelInfoFacade {

	@Autowired
	private CustomisedOrderPackageHotelInfoService customisePackageHotelInfoService;

	public CustomisePackageHotelInfoPojoResponse create(CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo) {
		CustomisedOrderPackageHotelInfo customisePackageHotelInfo = ObjectMapperUtils.map(customisePackageHotelInfoPojo,
				CustomisedOrderPackageHotelInfo.class);
		customisePackageHotelInfo = customisePackageHotelInfoService.create(customisePackageHotelInfo);
		customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisedOrderPackageHotelInfoPojo.class);
		return createDeleteUpdateResponse(customisePackageHotelInfoPojo, "Order created Successfully ");
	}

	private CustomisePackageHotelInfoPojoResponse createDeleteUpdateResponse(
			CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo, String message) {
		CustomisePackageHotelInfoPojoResponse customisePackageHotelInfoPojoResponse = new CustomisePackageHotelInfoPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackageHotelInfoPojoResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		customisePackageHotelInfoPojoResponse.setSuccessMessaages(successMessages);
		return customisePackageHotelInfoPojoResponse;
	}

	public CustomisePackageHotelInfoPojoListResponse listAll() {
		CustomisePackageHotelInfoPojoListResponse CustomisePackageHotelInfoPojoListResponse = new CustomisePackageHotelInfoPojoListResponse();
		List<CustomisedOrderPackageHotelInfo> customisePackageHotelInfo = customisePackageHotelInfoService.listAll();
		List<CustomisedOrderPackageHotelInfoPojo> customisePackageHotelInfoPojo = ObjectMapperUtils
				.mapAll(customisePackageHotelInfo, CustomisedOrderPackageHotelInfoPojo.class);
		CustomisePackageHotelInfoPojoListResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		return CustomisePackageHotelInfoPojoListResponse;
	}

	public CustomisePackageHotelInfoPojoResponse getByid(Long id) {
		CustomisePackageHotelInfoPojoResponse customisePackageHotelInfoPojoResponse = new CustomisePackageHotelInfoPojoResponse();
		CustomisedOrderPackageHotelInfo customisePackageHotelInfo = customisePackageHotelInfoService.getById(id);
		CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisedOrderPackageHotelInfoPojo.class);
		customisePackageHotelInfoPojoResponse.setCustomisePackageHotelInfoPojo(customisePackageHotelInfoPojo);
		return customisePackageHotelInfoPojoResponse;
	}

	public CustomisePackageHotelInfoPojoResponse delete(long id) {
		customisePackageHotelInfoService.deleteById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackageHotelInfoPojoResponse update(CustomisedOrderPackageHotelInfoPojo customisePackageHotelInfoPojo) {
		CustomisedOrderPackageHotelInfo customisePackageHotelInfo = customisePackageHotelInfoService
				.getById(customisePackageHotelInfoPojo.getId());
		ObjectMapperUtils.map(customisePackageHotelInfoPojo, customisePackageHotelInfo);
		customisePackageHotelInfo = customisePackageHotelInfoService.Update(customisePackageHotelInfo);
		customisePackageHotelInfoPojo = ObjectMapperUtils.map(customisePackageHotelInfo,
				CustomisedOrderPackageHotelInfoPojo.class);
		return createDeleteUpdateResponse(customisePackageHotelInfoPojo, "Updated successfully");
	}

}
