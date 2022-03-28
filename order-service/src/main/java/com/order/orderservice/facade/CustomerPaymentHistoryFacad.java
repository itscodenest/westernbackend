package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerPaymentHistoryService;
import com.tourcoreservice.entity.CustomerPaymentHistory;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerPaymentHistoryPojo;
import com.tourcoreservice.response.orders.CustomerPaymentHistoryListPojoResponse;
import com.tourcoreservice.response.orders.CustomerPaymentHistoryPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerPaymentHistoryFacad {

	@Autowired
	private CustomerPaymentHistoryService cService;

	public CustomerPaymentHistoryPojoResponse createpay(CustomerPaymentHistoryPojo cPojo) {
		try {
			CustomerPaymentHistory customerPayment = ObjectMapperUtils.map(cPojo, CustomerPaymentHistory.class);
			customerPayment = cService.create(customerPayment);
			cPojo = ObjectMapperUtils.map(customerPayment, CustomerPaymentHistoryPojo.class);
			return createDeleteUpdateResponse(cPojo, "CustomisePackage created Successfully ");
		} catch (Exception e) {
			return createDeleteUpdateResponse(null, e.toString());
		}

	}

	public CustomerPaymentHistoryListPojoResponse listAll() {

		CustomerPaymentHistoryListPojoResponse cResponse = new CustomerPaymentHistoryListPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> message = new ArrayList<>();
		try {
			List<CustomerPaymentHistory> cPayments = cService.listAll();
			List<CustomerPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentHistoryPojo.class);
			cResponse.setCustomerPaymentHistoryPojo(cPaymentPojos);
			responseMessagePojo.setMessage("Successfull");
			message.add(responseMessagePojo);
			cResponse.setSuccessMessaages(message);
		} catch (Exception e) {
			responseMessagePojo.setMessage(e.getMessage());
			message.add(responseMessagePojo);
			cResponse.setErorrMessagePojo(message);
		}
		return cResponse;
	}

	public CustomerPaymentHistoryPojoResponse getByid(Long id) {
		CustomerPaymentHistory customerpay = cService.getDataId(id);
		CustomerPaymentHistoryPojo cPaymentPojo = ObjectMapperUtils.map(customerpay, CustomerPaymentHistoryPojo.class);
		return createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}

	public CustomerPaymentHistoryListPojoResponse listbyOrder(Long orderid) {
		CustomerPaymentHistoryListPojoResponse cPojoListResponse = new CustomerPaymentHistoryListPojoResponse();
		List<CustomerPaymentHistory> cPayments = cService.listallOnOrder(orderid);
		List<CustomerPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentHistoryPojo.class);
		cPojoListResponse.setCustomerPaymentHistoryPojo(cPaymentPojos);
		return cPojoListResponse;
	}

	public CustomerPaymentHistoryListPojoResponse listAllbycustomer(String customerid) {
		CustomerPaymentHistoryListPojoResponse cPojoListResponse = new CustomerPaymentHistoryListPojoResponse();
		List<CustomerPaymentHistory> cPayments = cService.listallONcustomer(customerid);
		List<CustomerPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentHistoryPojo.class);
		cPojoListResponse.setCustomerPaymentHistoryPojo(cPaymentPojos);
		return cPojoListResponse;
	}

	public CustomerPaymentHistoryPojoResponse delete(long id) {
		cService.deletePayment(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerPaymentHistoryPojoResponse update(CustomerPaymentHistoryPojo cPaymentPojo) {
		CustomerPaymentHistory cPayment = cService.getDataId(cPaymentPojo.getId());
		ObjectMapperUtils.map(cPaymentPojo, cPayment);
		cPayment = cService.Update(cPayment);
		cPaymentPojo = ObjectMapperUtils.map(cPayment, CustomerPaymentHistoryPojo.class);
		return createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}

	private CustomerPaymentHistoryPojoResponse createDeleteUpdateResponse(CustomerPaymentHistoryPojo cPojo,
			String message) {
		CustomerPaymentHistoryPojoResponse customisePackagePojoRespone = new CustomerPaymentHistoryPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setCustomerPaymentHistory(cPojo);
		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}

}
