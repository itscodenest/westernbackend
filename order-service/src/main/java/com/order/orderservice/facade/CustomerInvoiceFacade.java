package com.order.orderservice.facade;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerinvoiceService;
import com.tourcoreservice.entity.CustomerInvoice;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerInvoicePojo;
import com.tourcoreservice.response.orders.CustomerInvoicePojoListResponse;
import com.tourcoreservice.response.orders.CustomerInvoicePojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerInvoiceFacade {

	@Autowired
	private CustomerinvoiceService cService;

	public CustomerInvoicePojoResponse create(CustomerInvoicePojo cPojo) throws ParseException {
		CustomerInvoice cInvoice = ObjectMapperUtils.map(cPojo, CustomerInvoice.class);
		cInvoice = cService.create(cInvoice);
		cPojo = ObjectMapperUtils.map(cInvoice, CustomerInvoicePojo.class);
		Long invoiceid = cPojo.getId();
		// generating invoice number(need created id
		if (invoiceid != null) {
			boolean ispreforma = cPojo.isIsproforma();
			if (ispreforma == true) {
				cPojo.setInvoicenumber("PROFORMA");
			} else {
				String prefix = "INV";
				LocalDate localDate = LocalDate.now();
				localDate = LocalDate.now(ZoneId.of("GMT+05:30"));
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMyy");
				formatter.format(localDate);
				String datestring = localDate.toString();
				prefix = prefix + datestring + invoiceid.toString();
				cPojo.setInvoicenumber(prefix);
			}
			cInvoice = ObjectMapperUtils.map(cPojo, CustomerInvoice.class);
			cInvoice = cService.Update(cInvoice);
		}
		cPojo = ObjectMapperUtils.map(cInvoice, CustomerInvoicePojo.class);
		return createDeleteUpdateResponse(cPojo, "Invoice created Successfully ");
	}

	private CustomerInvoicePojoResponse createDeleteUpdateResponse(CustomerInvoicePojo cPojo, String message) {
		CustomerInvoicePojoResponse cInvoicePojoResponse = new CustomerInvoicePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		cInvoicePojoResponse.setcInvoicePojo(cPojo);
		cInvoicePojoResponse.setSuccessMessaages(successMessages);
		return cInvoicePojoResponse;
	}

	public CustomerInvoicePojoListResponse listAll() {
		CustomerInvoicePojoListResponse cListResponse = new CustomerInvoicePojoListResponse();
		List<CustomerInvoice> cInvoices = cService.listAll();
		List<CustomerInvoicePojo> cPojos = ObjectMapperUtils.mapAll(cInvoices, CustomerInvoicePojo.class);
		cListResponse.setcPojos(cPojos);
		return cListResponse;
	}

	public CustomerInvoicePojoListResponse listbyOrder(Long orderid) {
		CustomerInvoicePojoListResponse cPojoListResponse = new CustomerInvoicePojoListResponse();
		List<CustomerInvoice> cQoutes = cService.listallOnOrder(orderid);

		List<CustomerInvoicePojo> cQoutesPojos = ObjectMapperUtils.mapAll(cQoutes, CustomerInvoicePojo.class);
		cPojoListResponse.setcPojos(cQoutesPojos);
		return cPojoListResponse;
	}

	public CustomerInvoicePojoResponse getByid(Long id) {
		CustomerInvoicePojoResponse cResponse = new CustomerInvoicePojoResponse();
		CustomerInvoice customerInvoice = cService.getDataId(id);
		CustomerInvoicePojo customerInvoicePojo = ObjectMapperUtils.map(customerInvoice, CustomerInvoicePojo.class);
		cResponse.setcInvoicePojo(customerInvoicePojo);
		return cResponse;
	}

	public CustomerInvoicePojoResponse delete(long id) {
		cService.deleteInvoice(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerInvoicePojoResponse update(CustomerInvoicePojo cPojo) {
		CustomerInvoice customerInvoice = cService.getDataId(cPojo.getId());
		ObjectMapperUtils.map(customerInvoice, cPojo);
		customerInvoice = cService.Update(customerInvoice);
		cPojo = ObjectMapperUtils.map(customerInvoice, CustomerInvoicePojo.class);
		return createDeleteUpdateResponse(cPojo, "Updated successfully");
	}

}
