package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.BtoBPaymentHistoryService;
import com.tourcoreservice.entity.BtoBPaymentHistory;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.BtoBPaymentHistoryPojo;
import com.tourcoreservice.response.orders.BtoBPaymentHistoryListPojoResponse;
import com.tourcoreservice.response.orders.BtoBPaymentHistoryPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class BtoBPaymentHistoryFacad {

	@Autowired
	private  BtoBPaymentHistoryService cService;

	public BtoBPaymentHistoryPojoResponse createpay(BtoBPaymentHistoryPojo cPojo) {
		try {
			BtoBPaymentHistory bPayment = ObjectMapperUtils.map(cPojo, BtoBPaymentHistory.class);
			bPayment = cService.create(bPayment);
			cPojo = ObjectMapperUtils.map(bPayment, BtoBPaymentHistoryPojo.class);
			return createDeleteUpdateResponse(cPojo, "CustomisePackage created Successfully ");
		} catch (Exception e) {
			return createDeleteUpdateResponse(null, e.toString());
		}

	}

	public BtoBPaymentHistoryListPojoResponse listAll() {

		BtoBPaymentHistoryListPojoResponse cResponse = new BtoBPaymentHistoryListPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> message = new ArrayList<>();
		try {
			List<BtoBPaymentHistory> cPayments = cService.listAll();
			List<BtoBPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, BtoBPaymentHistoryPojo.class);
			cResponse.setbPaymentHistoryPojo(cPaymentPojos);
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

	public BtoBPaymentHistoryPojoResponse getByid(Long id) {
		BtoBPaymentHistory customerpay = cService.getDataId(id);
		BtoBPaymentHistoryPojo cPaymentPojo = ObjectMapperUtils.map(customerpay, BtoBPaymentHistoryPojo.class);
		return createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}

	public BtoBPaymentHistoryListPojoResponse listbyOrder(Long orderid) {
		BtoBPaymentHistoryListPojoResponse cPojoListResponse = new BtoBPaymentHistoryListPojoResponse();
		List<BtoBPaymentHistory> cPayments = cService.listallOnOrder(orderid);
		List<BtoBPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, BtoBPaymentHistoryPojo.class);
		cPojoListResponse.setbPaymentHistoryPojo(cPaymentPojos);
		return cPojoListResponse;
	}

	public BtoBPaymentHistoryListPojoResponse listAllbycustomer(Long customerid) {
		BtoBPaymentHistoryListPojoResponse cPojoListResponse = new BtoBPaymentHistoryListPojoResponse();
		List<BtoBPaymentHistory> cPayments = cService.listallONcustomer(customerid);
		List<BtoBPaymentHistoryPojo> cPaymentPojos = ObjectMapperUtils.mapAll(cPayments, BtoBPaymentHistoryPojo.class);
		cPojoListResponse.setbPaymentHistoryPojo(cPaymentPojos);
		return cPojoListResponse;
	}

	public BtoBPaymentHistoryPojoResponse delete(long id) {
		cService.deletePayment(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public BtoBPaymentHistoryPojoResponse update(BtoBPaymentHistoryPojo cPaymentPojo) {
		BtoBPaymentHistory cPayment = cService.getDataId(cPaymentPojo.getId());
		ObjectMapperUtils.map(cPaymentPojo, cPayment);
		cPayment = cService.Update(cPayment);
		cPaymentPojo = ObjectMapperUtils.map(cPayment, BtoBPaymentHistoryPojo.class);
		return createDeleteUpdateResponse(cPaymentPojo, "Updated successfully");
	}

	private BtoBPaymentHistoryPojoResponse createDeleteUpdateResponse(BtoBPaymentHistoryPojo cPojo,
			String message) {
		BtoBPaymentHistoryPojoResponse customisePackagePojoRespone = new BtoBPaymentHistoryPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setbPaymentHistoryPojo(cPojo);
		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}
}
