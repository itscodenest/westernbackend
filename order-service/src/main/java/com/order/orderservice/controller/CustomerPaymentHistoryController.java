package com.order.orderservice.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.CustomerPaymentHistoryFacad;
import com.tourcoreservice.pojo.orders.CustomerPaymentHistoryPojo;
import com.tourcoreservice.response.orders.CustomerPaymentHistoryListPojoResponse;
import com.tourcoreservice.response.orders.CustomerPaymentHistoryPojoResponse;

@RestController
@RequestMapping("/custumerPaymentHistory")
public class CustomerPaymentHistoryController {
	
	@Autowired
	private CustomerPaymentHistoryFacad cFacade;

	@PostMapping
	public CustomerPaymentHistoryPojoResponse createCustomisePayment(@RequestBody CustomerPaymentHistoryPojo cPojo) throws ParseException {
		return cFacade.createpay(cPojo);
	}
	

	@GetMapping
	public CustomerPaymentHistoryListPojoResponse  getAllCustomisePayment() {
		return cFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomerPaymentHistoryPojoResponse getCustomerPaymentById(@PathVariable Long id) {
		return cFacade.getByid(id);
	}
	
	@GetMapping("/bycustomer/{Customerid}")
	public CustomerPaymentHistoryListPojoResponse getAllpayHistoryData(@PathVariable Long customerid) {
		return cFacade.listAllbycustomer(customerid);
	}
	
	@GetMapping("/byorder/{Orderid}")
	public CustomerPaymentHistoryListPojoResponse getQoutesbyOrder(@PathVariable Long Orderid) {
		return cFacade.listbyOrder(Orderid);
	}

	@PutMapping
	public CustomerPaymentHistoryPojoResponse updateCustomisePaymentById(@RequestBody CustomerPaymentHistoryPojo cPaymentPojo) {
		return cFacade.update(cPaymentPojo);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacade.delete(id);
	}


}
