package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomisedOrderPackageService;
import com.tourcoreservice.entity.CustomisedOrderPackage;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackagePojo;
import com.tourcoreservice.response.orders.CustomisePackagePojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackagePojoRespone;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomisedOrderPackageFacade {

	@Autowired
	private CustomisedOrderPackageService customisePackageService;

	public CustomisePackagePojoRespone create(CustomisedOrderPackagePojo customisePackagePojo) {
		CustomisedOrderPackage customisePackage = ObjectMapperUtils.map(customisePackagePojo, CustomisedOrderPackage.class);
		customisePackage = customisePackageService.create(customisePackage);
		customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisedOrderPackagePojo.class);
		return createDeleteUpdateResponse(customisePackagePojo, "CustomisePackage created Successfully ");
	}

	public CustomisePackagePojoListResponse listAll() {
		CustomisePackagePojoListResponse customisePackagePojoListResponse = new CustomisePackagePojoListResponse();
		List<CustomisedOrderPackage> customisePackage = customisePackageService.listAll();
		List<CustomisedOrderPackagePojo> customisePackagePojo = ObjectMapperUtils.mapAll(customisePackage,
				CustomisedOrderPackagePojo.class);
		customisePackagePojoListResponse.setCustomisePackagePojo(customisePackagePojo);

		return customisePackagePojoListResponse;
	}

	public CustomisePackagePojoRespone getData(Long id) {
		CustomisePackagePojoRespone customisePackagePojoRespone = new CustomisePackagePojoRespone();
		CustomisedOrderPackage customisePackage = customisePackageService.getDataId(id);
		CustomisedOrderPackagePojo customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisedOrderPackagePojo.class);
		customisePackagePojoRespone.setCustomisePackagePojo(customisePackagePojo);

		return customisePackagePojoRespone;
	}

	public CustomisePackagePojoRespone delete(long id) {
		customisePackageService.deletePacakge(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomisePackagePojoRespone update(CustomisedOrderPackagePojo customisePackagePojo) {
		CustomisedOrderPackage customisePackage = customisePackageService.getDataId(customisePackagePojo.getId());
		ObjectMapperUtils.map(customisePackagePojo, customisePackage);
		customisePackage = customisePackageService.Update(customisePackage);
		customisePackagePojo = ObjectMapperUtils.map(customisePackage, CustomisedOrderPackagePojo.class);
		return createDeleteUpdateResponse(customisePackagePojo, "Updated successfully");
	}

	private CustomisePackagePojoRespone createDeleteUpdateResponse(CustomisedOrderPackagePojo customisePackagePojo,
			String message) {
		CustomisePackagePojoRespone customisePackagePojoRespone = new CustomisePackagePojoRespone();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setCustomisePackagePojo(customisePackagePojo);

		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}
}