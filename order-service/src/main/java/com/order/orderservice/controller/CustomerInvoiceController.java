package com.order.orderservice.controller;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.CustomerInvoiceFacade;
import com.tourcoreservice.pojo.orders.CustomerInvoicePojo;
import com.tourcoreservice.response.orders.CustomerInvoicePojoListResponse;
import com.tourcoreservice.response.orders.CustomerInvoicePojoResponse;

@RestController
@RequestMapping("/custumerInvoice")
public class CustomerInvoiceController {
	
	@Autowired
	private CustomerInvoiceFacade cFacade;

	@PostMapping
	public CustomerInvoicePojoResponse createCustomisePackage(@RequestBody CustomerInvoicePojo cPojo) throws ParseException {
		return cFacade.create(cPojo);
	}
	

	@GetMapping
	public CustomerInvoicePojoListResponse getAllCustomisePackage() {
		return cFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomerInvoicePojoResponse getCustomerInvoiceById(@PathVariable Long id) {
		return cFacade.getByid(id);
	}

	@GetMapping("/byorder/{Orderid}")
	public CustomerInvoicePojoListResponse getQoutesbuOrder(@PathVariable Long Orderid) {
		return cFacade.listbyOrder(Orderid);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacade.delete(id);
	}


}
