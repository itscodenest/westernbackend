package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerVoucherService;
import com.tourcoreservice.entity.CustomerVoucher;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerVouchersPojo;
import com.tourcoreservice.response.orders.CustomerVoucherPojoListResponse;
import com.tourcoreservice.response.orders.CustomerVoucherPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerVoucherFacad {
	
	@Autowired
	private CustomerVoucherService cService;

	public CustomerVoucherPojoResponse create(CustomerVouchersPojo cVouchersPojo) {
		try {
			CustomerVoucher cVoucher = ObjectMapperUtils.map(cVouchersPojo, CustomerVoucher.class);
			cVoucher = cService.create(cVoucher);
			cVouchersPojo = ObjectMapperUtils.map(cVoucher, CustomerVouchersPojo.class);
			return createDeleteUpdateResponse(cVouchersPojo, "Customer voucher created Successfully ");
		}
		catch(Exception e) {
			return createDeleteUpdateResponse(null, e.toString());
		}
			
	}


	public CustomerVoucherPojoListResponse listAll() {
		CustomerVoucherPojoListResponse cResponse = new CustomerVoucherPojoListResponse();
		List<CustomerVoucher> cList = cService.listAll();
		List<CustomerVouchersPojo> cPojos = ObjectMapperUtils.mapAll(cList, CustomerVouchersPojo.class);
		cResponse.setcList(cPojos);
		return cResponse;
	}
	
	

	public CustomerVoucherPojoListResponse listbyOrder(Long orderid) {
		CustomerVoucherPojoListResponse cPojoListResponse = new CustomerVoucherPojoListResponse();
		List<CustomerVoucher> cList = cService.listallOnOrder(orderid);
		List<CustomerVouchersPojo> cPojos = ObjectMapperUtils.mapAll(cList, CustomerVouchersPojo.class);
		cPojoListResponse.setcList(cPojos);
		return cPojoListResponse;
	}
	
	public CustomerVoucherPojoListResponse listAllbycustomer(String id) {
		CustomerVoucherPojoListResponse cPojoListResponse = new CustomerVoucherPojoListResponse();
		List<CustomerVoucher> cList = cService.listallONcustomer(id);
		List<CustomerVouchersPojo> cVouchersPojos = ObjectMapperUtils.mapAll(cList, CustomerVouchersPojo.class);
		cPojoListResponse.setcList(cVouchersPojos);
		return cPojoListResponse;
	}
	public CustomerVoucherPojoResponse getData(Long id) {
		CustomerVoucherPojoResponse cResponse = new CustomerVoucherPojoResponse();
		CustomerVoucher cVoucher = cService.getDataId(id);
		CustomerVouchersPojo cPojo = ObjectMapperUtils.map(cVoucher, CustomerVouchersPojo.class);
		cResponse.setcVoucher(cPojo);
		return cResponse;
	}

	public CustomerVoucherPojoResponse delete(long id) {
		cService.deletebyid(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerVoucherPojoResponse update(CustomerVouchersPojo cPojo) {
		CustomerVoucher cVoucher = cService.getDataId(cPojo.getId());
		ObjectMapperUtils.map(cPojo, cVoucher);
		cVoucher = cService.Update(cVoucher);
		cPojo = ObjectMapperUtils.map(cVoucher, CustomerVouchersPojo.class);
		return createDeleteUpdateResponse(cPojo, "Updated successfully");
	}
	
	
	
	private CustomerVoucherPojoResponse createDeleteUpdateResponse(CustomerVouchersPojo cVouchersPojo, String message) {
		CustomerVoucherPojoResponse customisePackagePojoRespone = new CustomerVoucherPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setcVoucher(cVouchersPojo);
		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}

	
	


}
