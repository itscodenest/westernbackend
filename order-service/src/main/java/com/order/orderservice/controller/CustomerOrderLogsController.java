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

import com.order.orderservice.facade.CustomerOrderLogsFacade;
import com.tourcoreservice.pojo.orders.CustomerOrderLogsPojo;
import com.tourcoreservice.response.orders.CustomerOrderLogsListPojoResponse;
import com.tourcoreservice.response.orders.CustomerOrderLogsPojoResponse;

@RestController
@RequestMapping("/custumerOrderLogs")
public class CustomerOrderLogsController {
	
	@Autowired
	private CustomerOrderLogsFacade cFacade;

	@PostMapping
	public CustomerOrderLogsPojoResponse createCustomerlogs(@RequestBody CustomerOrderLogsPojo cPojo) throws ParseException {
		return cFacade.create(cPojo);
	}
	

	@GetMapping("/{orderid}")
	public CustomerOrderLogsListPojoResponse getAllordermessagebyid(@PathVariable Long orderid) {
		return cFacade.listbyOrder(orderid);
	}

	@PutMapping
	public CustomerOrderLogsPojoResponse updateCustomiselogsById(@RequestBody CustomerOrderLogsPojo cPojo) {
		return cFacade.update(cPojo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacade.delete(id);
	}
	
	

}
