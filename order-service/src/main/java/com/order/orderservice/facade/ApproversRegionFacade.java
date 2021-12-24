package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import com.order.orderservice.service.ApproversRegionService;
import com.tourcoreservice.entity.ApproverRegion;
import com.tourcoreservice.exception.tourpackage.DataAlreadyExistException;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.ApproverRegionPojo;
import com.tourcoreservice.pojo.orders.ApproversRegionPojo;
import com.tourcoreservice.response.orders.ApproverRegionPojoListResponse;
import com.tourcoreservice.response.orders.ApproverRegionPojoResponse;
import com.tourcoreservice.response.orders.ApproversRegionPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class ApproversRegionFacade {

	@Autowired
	private ApproversRegionService approversRegionService;

	public ApproverRegionPojoResponse create(ApproverRegionPojo approverRegionPojo) {
		// ifRegionNameExist(approverRegionPojo.getRegionName());
		ApproverRegion approverRegion = ObjectMapperUtils.map(approverRegionPojo, ApproverRegion.class);
		approverRegion = approversRegionService.create(approverRegion);
		approverRegionPojo = ObjectMapperUtils.map(approverRegion, ApproverRegionPojo.class);
		return createDeleteUpdateResponse(approverRegionPojo, "Approvers resgion created Successfully ");
	}

	private void ifRegionNameExist(String regionName) {
		ApproverRegion approverRegion = approversRegionService.findRegionByName(regionName);
		if (!ObjectUtils.isEmpty(approverRegion)) {
			throw new DataAlreadyExistException("Data already exists");
		}
	}

	private ApproverRegionPojoResponse createDeleteUpdateResponse(ApproverRegionPojo approverRegionPojo,
			String message) {
		ApproverRegionPojoResponse approverRegionPojoResponse = new ApproverRegionPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		approverRegionPojoResponse.setApproverRegionPojo(approverRegionPojo);
		approverRegionPojoResponse.setSuccessMessaages(successMessages);
		return approverRegionPojoResponse;
	}

	public ApproverRegionPojoListResponse listAll() {
		ApproverRegionPojoListResponse approverRegionPojoListResponse = new ApproverRegionPojoListResponse();
		List<ApproverRegion> approverRegion = approversRegionService.listAll();
		List<ApproverRegionPojo> aproverRegionPojo = ObjectMapperUtils.mapAll(approverRegion, ApproverRegionPojo.class);
		approverRegionPojoListResponse.setApproverRegionPojo(aproverRegionPojo);
		return approverRegionPojoListResponse;
	}

	public ApproverRegionPojoResponse getByid(Long id) {
		ApproverRegionPojoResponse approverRegionPojoResponse = new ApproverRegionPojoResponse();
		ApproverRegion approverRegion = approversRegionService.getyId(id);
		ApproverRegionPojo approverRegionPojo = ObjectMapperUtils.map(approverRegion, ApproverRegionPojo.class);
		approverRegionPojoResponse.setApproverRegionPojo(approverRegionPojo);
		return approverRegionPojoResponse;
	}

	public ApproverRegionPojoResponse delete(long id) {
		approversRegionService.deleteById(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");
	}

	public ApproverRegionPojoResponse update(ApproverRegionPojo approverRegionPojo) {
		ApproverRegion approverRegion = approversRegionService.getyId(approverRegionPojo.getId());
		ObjectMapperUtils.map(approverRegionPojo, approverRegion);
		approverRegion = approversRegionService.Update(approverRegion);
		approverRegionPojo = ObjectMapperUtils.map(approverRegion, ApproverRegionPojo.class);
		return createDeleteUpdateResponse(approverRegionPojo, "Updated successfully");
	}

	public ApproversRegionPojoResponse getApproversByName(String regionName) {
		ApproversRegionPojoResponse approversRegionPojoResponse = new ApproversRegionPojoResponse();
		ApproverRegion approverRegion = approversRegionService.findRegionByName(regionName);
		ApproversRegionPojo approversRegionPojo = ObjectMapperUtils.map(approverRegion, ApproversRegionPojo.class);

		approversRegionPojoResponse.setApproversRegionPojo(approversRegionPojo);
		return approversRegionPojoResponse;
	}

	public ApproverRegionPojoResponse getApproversByRegionName(ApproverRegionPojo approverRegionPojo) {
		ApproverRegionPojoResponse approversRegionPojoResponse = new ApproverRegionPojoResponse();
		ApproverRegion approverRegion = approversRegionService
				.getApproverByRegionName(approverRegionPojo.getRegionName());
		ApproverRegionPojo approversRegionPojo = ObjectMapperUtils.map(approverRegion, ApproverRegionPojo.class);
		approversRegionPojoResponse.setApproverRegionPojo(approversRegionPojo);
		return approversRegionPojoResponse;
	}

	/*
	 * public ApproverRegionPojoListResponse getApproversByName(String regionName) {
	 * ApproverRegionPojoListResponse approversRegionPojoListResponse = new
	 * ApproverRegionPojoListResponse(); List<ApproverRegion> approverRegion =
	 * approversRegionService.findRegionByName(regionName); List<ApproverRegionPojo>
	 * approversRegionPojo = ObjectMapperUtils.mapAll(approverRegion,
	 * ApproverRegionPojo.class); List<ApproverRegionPojo> filteredApproversRegion =
	 * new ArrayList<ApproverRegionPojo>();
	 * approversRegionPojo.stream().forEach(approversRegion -> { if
	 * (approversRegion.getRegionName().equals(regionName)) {
	 * filteredApproversRegion.add(approversRegion); } });
	 * approversRegionPojoListResponse.setApproverRegionPojo(filteredApproversRegion
	 * ); return approversRegionPojoListResponse; }
	 */

}
