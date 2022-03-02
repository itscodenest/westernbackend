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
import com.order.orderservice.facade.CustomerpaymentFacade;
import com.tourcoreservice.pojo.orders.CustomerPaymentPojo;
import com.tourcoreservice.response.orders.CustomerPaymentPojoListResponse;
import com.tourcoreservice.response.orders.CustomerPaymentPojoResponse;

@RestController
@RequestMapping("/custumerPayment")
public class CustomerpaymentController {
	
	@Autowired
	private CustomerpaymentFacade cFacade;

	@PostMapping
	public CustomerPaymentPojoResponse createCustomisePayment(@RequestBody CustomerPaymentPojo cPojo) throws ParseException {
		return cFacade.create(cPojo);
	}
	

	@GetMapping
	public CustomerPaymentPojoListResponse getAllCustomisePayment() {
		return cFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomerPaymentPojoResponse getCustomerPaymentById(@PathVariable Long id) {
		return cFacade.getByid(id);
	}
	
	@GetMapping("/bycustomer/{Customerid}")
	public CustomerPaymentPojoListResponse getAllQoutesPartialData(@PathVariable Long customerid) {
		return cFacade.listAllbycustomer(customerid);
	}
	
	@GetMapping("/byorder/{Orderid}")
	public CustomerPaymentPojoListResponse getQoutesbyOrder(@PathVariable Long Orderid) {
		return cFacade.listbyOrder(Orderid);
	}

	@PutMapping
	public CustomerPaymentPojoResponse updateCustomisePaymentById(@RequestBody CustomerPaymentPojo cPaymentPojo) {
		return cFacade.update(cPaymentPojo);
	}
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacade.delete(id);
	}

}
