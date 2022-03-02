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

import com.order.orderservice.facade.BtoBPaymentHistoryFacad;
import com.tourcoreservice.pojo.orders.BtoBPaymentHistoryPojo;
import com.tourcoreservice.response.orders.BtoBPaymentHistoryListPojoResponse;
import com.tourcoreservice.response.orders.BtoBPaymentHistoryPojoResponse;

@RestController
@RequestMapping("/btobPayment")
public class BtoBPaymentHistoryController {

	@Autowired
	private BtoBPaymentHistoryFacad cFacade;

	@PostMapping
	public BtoBPaymentHistoryPojoResponse createBtoBPayment(@RequestBody BtoBPaymentHistoryPojo cPojo)
			throws ParseException {
		return cFacade.createpay(cPojo);
	}

	@GetMapping
	public BtoBPaymentHistoryListPojoResponse getAllBtoBPayment() {
		return cFacade.listAll();
	}

	@GetMapping("/{id}")
	public BtoBPaymentHistoryPojoResponse getBtoBPaymentById(@PathVariable Long id) {
		return cFacade.getByid(id);
	}

	@GetMapping("/bycustomer/{Customerid}")
	public BtoBPaymentHistoryListPojoResponse getAllpayHistoryData(@PathVariable Long customerid) {
		return cFacade.listAllbycustomer(customerid);
	}

	@GetMapping("/byorder/{Orderid}")
	public BtoBPaymentHistoryListPojoResponse getQoutesbyOrder(@PathVariable Long Orderid) {
		return cFacade.listbyOrder(Orderid);
	}

	@PutMapping
	public BtoBPaymentHistoryPojoResponse updateCustomisePaymentById(@RequestBody BtoBPaymentHistoryPojo cPaymentPojo) {
		return cFacade.update(cPaymentPojo);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacade.delete(id);
	}

}
