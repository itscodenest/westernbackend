package com.order.orderservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.CustomerQoutesFacade;
import com.tourcoreservice.pojo.orders.CustomerQoutesPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageFlightinfoPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageHotelInfoPojo;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;
import com.tourcoreservice.response.orders.CustomerQoutesPojoListResponse;
import com.tourcoreservice.response.orders.CustomerQoutesPojoResponse;

@RestController
@RequestMapping("/custumerQoutes")
public class CustomerQoutesController {


	@Autowired
	private CustomerQoutesFacade customerQoutesFacade;

	@PostMapping
	public CustomerQoutesPojoResponse createCustomisePackage(@RequestBody CustomerQoutesPojo cQoutesPojo) {
		return customerQoutesFacade.create(cQoutesPojo);
	}
	
	@PostMapping("/flight/{id}")
	public CustomerQoutesPojoResponse createQoutesFlights(@RequestBody List<CustomisedOrderPackageFlightinfoPojo> flightSet,@PathVariable Long id) {
		return customerQoutesFacade.createflights(flightSet,id);
	}
	
	@PostMapping("/Hotels/{id}")
	public CustomerQoutesPojoResponse createQoutesHotels(@RequestBody List<CustomisedOrderPackageHotelInfoPojo> hotelPojo,@PathVariable Long id) {
		return customerQoutesFacade.createHotels(hotelPojo,id);
	}
	
	@PostMapping("/Iterneries/{id}")
	public CustomerQoutesPojoResponse createQoutesIterneries(@RequestBody List<CustomisedOrderPackageIteneryPojo> iteneryPojos,@PathVariable Long id) {
		return customerQoutesFacade.createIterneris(iteneryPojos,id);
	}

	@GetMapping
	public CustomerQoutesPojoListResponse getAllCustomisePackage() {
		return customerQoutesFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomerQoutesPojoResponse getCustomerQoutesById(@PathVariable Long id) {
		return customerQoutesFacade.getData(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customerQoutesFacade.delete(id);
	}

	@PutMapping
	public CustomerQoutesPojoResponse updateCustomisePackageById(@RequestBody CustomerQoutesPojo cQoutesPojo) {
		return customerQoutesFacade.update(cQoutesPojo);
	}
}
