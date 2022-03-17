package com.order.orderservice.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.order.orderservice.service.CustomerQoutesService;
import com.tourcoreservice.entity.CustomerQoutes;
import com.tourcoreservice.pojo.generic.ResponseMessagePojo;
import com.tourcoreservice.pojo.orders.CustomerQoutesPartialPojo;
import com.tourcoreservice.pojo.orders.CustomerQoutesPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageFlightinfoPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageHotelInfoPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;
import com.tourcoreservice.response.orders.CustomerQoutesPartialPojoListResponse;
import com.tourcoreservice.response.orders.CustomerQoutesPojoListResponse;
import com.tourcoreservice.response.orders.CustomerQoutesPojoResponse;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class CustomerQoutesFacade {

	@Autowired
	private CustomerQoutesService qoutesService;

	public CustomerQoutesPojoResponse create(CustomerQoutesPojo cQoutesPojo) {
		try {
			CustomerQoutes customerQoutes = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
			customerQoutes = qoutesService.create(customerQoutes);
			cQoutesPojo = ObjectMapperUtils.map(customerQoutes, CustomerQoutesPojo.class);
			return createDeleteUpdateResponse(cQoutesPojo, "CustomisePackage created Successfully ");
		}
		catch(Exception e) {
			return createDeleteUpdateResponse(null, e.toString());
		}
			
	}

	public CustomerQoutesPojoResponse createflights(List<CustomisedOrderPackageFlightinfoPojo> flightSet, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesFlight(flightSet);	
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Created flights successfully");
	}
	
	public CustomerQoutesPojoResponse createHotels(List<CustomisedOrderPackageHotelInfoPojo> HotelList, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesHotel(HotelList);
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Created Hotels successfully");
	}
	
	public CustomerQoutesPojoResponse createIterneris(List<CustomisedOrderPackageIteneryPojo> iteneryPojos, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesiternery(iteneryPojos);
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Created Hotels successfully");
	}

	public CustomerQoutesPojoListResponse listAll() {
		CustomerQoutesPojoListResponse cResponse = new CustomerQoutesPojoListResponse();
		List<CustomerQoutes> cQoutes = qoutesService.listAll();
		List<CustomerQoutesPojo> cQoutesPojos = ObjectMapperUtils.mapAll(cQoutes, CustomerQoutesPojo.class);
		cResponse.setcPojos(cQoutesPojos);
		return cResponse;
	}
	
	public CustomerQoutesPartialPojoListResponse listAllPartial(String customerid) {
		CustomerQoutesPartialPojoListResponse cPojoListResponse = new CustomerQoutesPartialPojoListResponse();
		List<CustomerQoutes> cQoutes = qoutesService.listallONcustomer(customerid);
		
		List<CustomerQoutesPartialPojo> cQoutesPojos = ObjectMapperUtils.mapAll(cQoutes, CustomerQoutesPartialPojo.class);
		cPojoListResponse.setcPojos(cQoutesPojos);
		return cPojoListResponse;
	}

	public CustomerQoutesPartialPojoListResponse listbyOrder(Long orderid) {
		CustomerQoutesPartialPojoListResponse cPojoListResponse = new CustomerQoutesPartialPojoListResponse();
		List<CustomerQoutes> cQoutes = qoutesService.listallOnOrder(orderid);
		
		List<CustomerQoutesPartialPojo> cQoutesPojos = ObjectMapperUtils.mapAll(cQoutes, CustomerQoutesPartialPojo.class);
		cPojoListResponse.setcPojos(cQoutesPojos);
		return cPojoListResponse;
	}
	public CustomerQoutesPojoResponse getData(Long id) {
		CustomerQoutesPojoResponse cResponse = new CustomerQoutesPojoResponse();
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cResponse.setQoutesPojo(cQoutesPojo);

		return cResponse;
	}

	public CustomerQoutesPojoResponse delete(long id) {
		qoutesService.deletePacakge(id);
		return createDeleteUpdateResponse(null, "Deleted successfully");

	}

	public CustomerQoutesPojoResponse update(CustomerQoutesPojo cQoutesPojo) {
		CustomerQoutes cQoutes = qoutesService.getDataId(cQoutesPojo.getId());
		ObjectMapperUtils.map(cQoutesPojo, cQoutes);
		cQoutes = qoutesService.Update(cQoutes);
		cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		return createDeleteUpdateResponse(cQoutesPojo, "Updated successfully");
	}
	
	
	public CustomerQoutesPojoResponse updateextra(CustomerQoutesPojo cQoutesPojo) {
		CustomerQoutes cQoutes = qoutesService.getDataId(cQoutesPojo.getId());
		CustomerQoutesPojo olddatapojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		olddatapojo.setTotalcost(cQoutesPojo.getTotalcost());
		olddatapojo.setAditionalinfo(cQoutesPojo.getAditionalinfo());//additional info
		olddatapojo.setInclusiontext(cQoutesPojo.getInclusiontext());
		olddatapojo.setExlusionText(cQoutesPojo.getExlusionText());
		olddatapojo.setPaymentPolicy(cQoutesPojo.getPaymentPolicy());
		olddatapojo.setTermsandconditions(cQoutesPojo.getTermsandconditions());
		CustomerQoutes updateddata = ObjectMapperUtils.map(olddatapojo, CustomerQoutes.class);
		updateddata = qoutesService.Update(updateddata);
		cQoutesPojo = ObjectMapperUtils.map(updateddata, CustomerQoutesPojo.class);
		return createDeleteUpdateResponse(cQoutesPojo, "Updated successfully");
	}

	private CustomerQoutesPojoResponse createDeleteUpdateResponse(CustomerQoutesPojo cQoutesPojo, String message) {
		CustomerQoutesPojoResponse customisePackagePojoRespone = new CustomerQoutesPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customisePackagePojoRespone.setQoutesPojo(cQoutesPojo);

		customisePackagePojoRespone.setSuccessMessaages(successMessages);
		return customisePackagePojoRespone;
	}

	public CustomerQoutesPojoResponse updateFlight(List<CustomisedOrderPackageFlightinfoPojo> flightSet, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesFlight(flightSet);	
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Update flights successfully");
	}

	public CustomerQoutesPojoResponse updateHotel(List<CustomisedOrderPackageHotelInfoPojo> hotelPojo, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesHotel(hotelPojo);
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Update Hotels successfully");
	}

	public CustomerQoutesPojoResponse updateIterneris(List<CustomisedOrderPackageIteneryPojo> iteneryPojos, Long id) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setCustomerQoutesiternery(iteneryPojos);
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Updated Hotels successfully");
	}

	public Object updateStatus(Long id,Long status) {
		CustomerQoutes cQoutes = qoutesService.getDataId(id);
		CustomerQoutesPojo cQoutesPojo = ObjectMapperUtils.map(cQoutes, CustomerQoutesPojo.class);
		cQoutesPojo.setStatus(status);
		CustomerQoutes cQoutesentity = ObjectMapperUtils.map(cQoutesPojo, CustomerQoutes.class);
		qoutesService.Update(cQoutesentity) ;
		return createDeleteUpdateResponse(null, "Updated status successfully");
	}

	

	

	

	

	
	
}
