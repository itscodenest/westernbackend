package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.service.CustomerProfileService;
import com.tourcoreservice.entity.CustomerProfile;
import com.tourcoreservice.pojo.account.CustomerProfilePojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.CustomerProfilePojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerProfileFacade {

	@Autowired
	CustomerProfileService customerProfileService;

	public CustomerProfilePojoResponse create(CustomerProfilePojo cProfilePojo) {
		CustomerProfile cProfile = ObjectMapperUtils.map(cProfilePojo, CustomerProfile.class);
		cProfile = customerProfileService.create(cProfile);
		cProfilePojo = ObjectMapperUtils.map(cProfile, CustomerProfilePojo.class);
		return createDeleteUpdateResponse(cProfilePojo, "Profile created");
	}

	public CustomerProfilePojoResponse delete(long id) {
		customerProfileService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	public CustomerProfilePojoResponse update(CustomerProfilePojo tPojo) {
		CustomerProfile cProfile = customerProfileService.findById(tPojo.getId());
		// deleteExisistingRole(user, user.getRoles());
		// deleteExisistingAddress(user, user.getAddresses());
		ObjectMapperUtils.map(tPojo, cProfile);
		cProfile = customerProfileService.update(cProfile);
		tPojo = ObjectMapperUtils.map(cProfile, CustomerProfilePojo.class);
		return createDeleteUpdateResponse(tPojo, "Updated successfully");
	}

	public CustomerProfilePojoResponse getTravellerById(long id) {
		CustomerProfile cProfile = customerProfileService.findById(id);
		CustomerProfilePojo cProfilePojo = ObjectMapperUtils.map(cProfile, CustomerProfilePojo.class);
		return createDeleteUpdateResponse(cProfilePojo, "");
	}

	public CustomerProfilePojoResponse getProfileBuTravellerid(String id) {
		try {
			CustomerProfile cProfile = customerProfileService.findbyuserid(id);
			if (cProfile != null) {
				CustomerProfilePojo cProfilePojo = ObjectMapperUtils.map(cProfile, CustomerProfilePojo.class);
				return createDeleteUpdateResponse(cProfilePojo, "");
			} else {
				return createDeleteUpdateResponse(null, "User Profile Not created yet");
			}

		} catch (Exception e) {
			e.printStackTrace();
			return createDeleteUpdateResponse(null, "User Profile Not created yet");
		}

	}

	private CustomerProfilePojoResponse createDeleteUpdateResponse(CustomerProfilePojo tPojo, String message) {
		CustomerProfilePojoResponse cPojoResponse = new CustomerProfilePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		cPojoResponse.setcPojo(tPojo);
		;
		cPojoResponse.setSuccessMessaages(successMessages);
		return cPojoResponse;
	}

}
