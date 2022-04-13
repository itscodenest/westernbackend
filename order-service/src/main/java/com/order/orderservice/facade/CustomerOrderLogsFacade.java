package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerOrderLogsService;
import com.tourcoreservice.entity.CustomerOrderLogs;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerOrderLogsPojo;
import com.tourcoreservice.response.orders.CustomerOrderLogsListPojoResponse;
import com.tourcoreservice.response.orders.CustomerOrderLogsPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerOrderLogsFacade {

	@Autowired
	private CustomerOrderLogsService logsservice;

	public CustomerOrderLogsPojoResponse create(CustomerOrderLogsPojo cOrderLogs) {
		CustomerOrderLogs cLogs = ObjectMapperUtils.map(cOrderLogs, CustomerOrderLogs.class);
		cLogs = logsservice.save(cLogs);
		cOrderLogs = ObjectMapperUtils.map(cLogs, CustomerOrderLogsPojo.class);
		return createDeleteUpdateResponse(cOrderLogs, "Created Successfull");
	}

	public CustomerOrderLogsListPojoResponse listbyOrder(Long orderid) {
		CustomerOrderLogsListPojoResponse cPojoListResponse = new CustomerOrderLogsListPojoResponse();
		List<CustomerOrderLogs> cOrderLogs = logsservice.getordermessages(orderid);
		List<CustomerOrderLogsPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cOrderLogs, CustomerOrderLogsPojo.class);
		cPojoListResponse.setcList(cPaymentPojos);
		;
		return cPojoListResponse;
	}

	public CustomerOrderLogsPojoResponse delete(long id) {
		logsservice.delete(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerOrderLogsPojoResponse update(CustomerOrderLogsPojo orderLogsPojo) {
		CustomerOrderLogs cOrderLogs = logsservice.getDataId(orderLogsPojo.getId());
		ObjectMapperUtils.map(orderLogsPojo, cOrderLogs);
		cOrderLogs = logsservice.update(cOrderLogs);
		orderLogsPojo = ObjectMapperUtils.map(cOrderLogs, CustomerOrderLogsPojo.class);
		return createDeleteUpdateResponse(orderLogsPojo, "Updated successfully");
	}

	private CustomerOrderLogsPojoResponse createDeleteUpdateResponse(CustomerOrderLogsPojo cPojo, String message) {
		CustomerOrderLogsPojoResponse cLogsPojoResponse = new CustomerOrderLogsPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		cLogsPojoResponse.setcPojo(cPojo);
		cLogsPojoResponse.setSuccessMessaages(successMessages);
		return cLogsPojoResponse;
	}
}
