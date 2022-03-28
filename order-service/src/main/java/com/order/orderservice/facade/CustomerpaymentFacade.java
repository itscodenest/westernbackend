package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerpaymentService;
import com.tourcoreservice.entity.CustomerPayment;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerPaymentPojo;
import com.tourcoreservice.response.orders.CustomerPaymentPojoListResponse;
import com.tourcoreservice.response.orders.CustomerPaymentPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerpaymentFacade {
	@Autowired
	private CustomerpaymentService cService;

	public CustomerPaymentPojoResponse create(CustomerPaymentPojo cPojo) {
		try {
			CustomerPayment customerPayment = ObjectMapperUtils.map(cPojo, CustomerPayment.class);
			customerPayment = cService.create(customerPayment);
			cPojo = ObjectMapperUtils.map(customerPayment, CustomerPaymentPojo.class);
			return createDeleteUpdateResponse(cPojo, "CustomisePackage created Successfully ");
		} catch (Exception e) {
			return createDeleteUpdateResponse(null, e.toString());
		}

	}

	public CustomerPaymentPojoListResponse listAll() {

		CustomerPaymentPojoListResponse cResponse = new CustomerPaymentPojoListResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> message = new ArrayList<>();
		try {
			List<CustomerPayment> cPayments = cService.listAll();
			List<CustomerPaymentPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentPojo.class);
			cResponse.setCustomerPaymentPojos(cPaymentPojos);
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

	public CustomerPaymentPojoResponse getByid(Long id) {
		CustomerPayment customerInvoice = cService.getDataId(id);
		CustomerPaymentPojo cPaymentPojo = ObjectMapperUtils.map(customerInvoice, CustomerPaymentPojo.class);
		return  createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}
	
	public CustomerPaymentPojoListResponse listbyOrder(Long orderid) {
		CustomerPaymentPojoListResponse cPojoListResponse = new CustomerPaymentPojoListResponse();
		List<CustomerPayment> cPayments = cService.listallOnOrder(orderid);
		
		List<CustomerPaymentPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentPojo.class);
		cPojoListResponse.setCustomerPaymentPojos(cPaymentPojos);
		return cPojoListResponse;
	}
	
	public CustomerPaymentPojoListResponse listAllbycustomer(String customerid) {
		CustomerPaymentPojoListResponse cPojoListResponse = new CustomerPaymentPojoListResponse();
		List<CustomerPayment> cPayments = cService.listallONcustomer(customerid);
		List<CustomerPaymentPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, CustomerPaymentPojo.class);
		cPojoListResponse.setCustomerPaymentPojos(cPaymentPojos);
		return cPojoListResponse;
	}
	public CustomerPaymentPojoResponse delete(long id) {
		cService.deletePayment(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerPaymentPojoResponse update(CustomerPaymentPojo cPaymentPojo) {
		CustomerPayment cPayment = cService.getDataId(cPaymentPojo.getId());
		ObjectMapperUtils.map(cPaymentPojo, cPayment);
		cPayment = cService.Update(cPayment);
		cPaymentPojo = ObjectMapperUtils.map(cPayment, CustomerPaymentPojo.class);
		return createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}
	
	private CustomerPaymentPojoResponse createDeleteUpdateResponse(CustomerPaymentPojo cQoutesPojo, String message) {
		CustomerPaymentPojoResponse customisePackagePojoRespone = new CustomerPaymentPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setCustomerPaymentPojo(cQoutesPojo);
		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}

}
