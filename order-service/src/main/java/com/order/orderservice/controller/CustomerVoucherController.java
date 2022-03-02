package com.order.orderservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.orderservice.facade.CustomerVoucherFacad;
import com.tourcoreservice.pojo.orders.CustomerVouchersPojo;
import com.tourcoreservice.response.orders.CustomerVoucherPojoListResponse;
import com.tourcoreservice.response.orders.CustomerVoucherPojoResponse;

@RestController
@RequestMapping("/custumerVouchers")
public class CustomerVoucherController {
	
	@Autowired
	private CustomerVoucherFacad cFacad;

	@PostMapping
	public CustomerVoucherPojoResponse createCustomisePackage(@RequestBody CustomerVouchersPojo cVouchersPojo) {
		return cFacad.create(cVouchersPojo);
	}
	
	@GetMapping
	public CustomerVoucherPojoListResponse getAllCustomisePackage() {
		return cFacad.listAll();
	}

	@GetMapping("/{id}")
	public CustomerVoucherPojoResponse getCustomervoucherById(@PathVariable Long id) {
		return cFacad.getData(id);
	}

	@GetMapping("/byorder/{Orderid}")
	public CustomerVoucherPojoListResponse getVouchersbuOrder(@PathVariable Long Orderid) {
		return cFacad.listbyOrder(Orderid);
	}
	
	@GetMapping("/bycustomer/{id}")
	public CustomerVoucherPojoListResponse getVouchersbycustomer(@PathVariable Long id) {
		return cFacad.listAllbycustomer(id);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		cFacad.delete(id);
	}
	
	@PutMapping
	public CustomerVoucherPojoResponse updateCustomisePackageById(@RequestBody CustomerVouchersPojo cfPojo) {
		return cFacad.update(cfPojo);
	}
	

}
