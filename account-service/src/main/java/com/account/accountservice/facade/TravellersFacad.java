package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.repository.LocalEmailServiceInterface;
import com.account.accountservice.service.TravellersService;
import com.tourcoreservice.entity.Travellers;
import com.tourcoreservice.pojo.account.TravellersPojo;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.response.account.TravellersPojoListResponse;
import com.tourcoreservice.response.account.TravellersPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class TravellersFacad {
	
	@Autowired
	TravellersService tService;
	
	@Autowired
	private LocalEmailServiceInterface localEmailServiceInterface;
	
	public TravellersPojoResponse create(TravellersPojo tPojo) {
		String userid = tPojo.getEmail();
		tPojo.setUsername(userid);
		Travellers user = ObjectMapperUtils.map(tPojo, Travellers.class);
		user = tService.create(user);
//		try {
//			localEmailServiceInterface.sendMailWithoutBody();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		tPojo = ObjectMapperUtils.map(user, TravellersPojo.class);
		return createDeleteUpdateResponse(tPojo, "customer CreatedSuccessfully");
	}

	public TravellersPojoListResponse listAll() {
		TravellersPojoListResponse tListResponse = new TravellersPojoListResponse();
		List<Travellers> travellers = tService.listAll();
		List<TravellersPojo> tPojos = ObjectMapperUtils.mapAll(travellers, TravellersPojo.class);
		tListResponse.settPojos(tPojos);
		return tListResponse;
	}
	
	public TravellersPojoResponse delete(long id) {
		tService.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	public TravellersPojoResponse update(TravellersPojo userPojo) {
		Travellers travellers = tService.getById(userPojo.getId());
//		deleteExisistingRole(user, user.getRoles());
//		deleteExisistingAddress(user, user.getAddresses());
		ObjectMapperUtils.map(userPojo, travellers);
		travellers = tService.Update(travellers);
		userPojo = ObjectMapperUtils.map(travellers, TravellersPojo.class);
		return createDeleteUpdateResponse(userPojo, "Updated successfully");
	}
	
	public TravellersPojoResponse getTravellerById(String id) {
		Travellers travellers = tService.getById(id);
		TravellersPojo travellersPojo = ObjectMapperUtils.map(travellers, TravellersPojo.class);
		return createDeleteUpdateResponse(travellersPojo, "");
	}
	
	
	private TravellersPojoResponse createDeleteUpdateResponse(TravellersPojo tPojo, String message) {
		TravellersPojoResponse userPojoResponse = new TravellersPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		userPojoResponse.settPojo(tPojo);
		userPojoResponse.setSuccessMessaages(successMessages);
		return userPojoResponse;
	}
	
	
	
	
	
}
