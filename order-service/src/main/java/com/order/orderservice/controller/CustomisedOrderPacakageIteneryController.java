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

import com.order.orderservice.facade.CustomisedOrderPackageIteneryFacade;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackageIteneryPojo;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackageItenaryPojoResponse;

@RestController
@RequestMapping("/customise-package-itenatry")
public class CustomisedOrderPacakageIteneryController {

	@Autowired
	private CustomisedOrderPackageIteneryFacade customisePackageItenaryFacade;

	@PostMapping
	public CustomisePackageItenaryPojoResponse createItenary(
			@RequestBody CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo) {
		return customisePackageItenaryFacade.createItenery(customisePackageItenaryPojo);
	}

	@GetMapping
	public CustomisePackageItenaryPojoListResponse listAllIteneries() {
		return customisePackageItenaryFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomisePackageItenaryPojoResponse getIteneryById(@PathVariable Long id) {
		return customisePackageItenaryFacade.getByid(id);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customisePackageItenaryFacade.delete(id);
	}

	@PutMapping
	public CustomisePackageItenaryPojoResponse updateById(@RequestBody CustomisedOrderPackageIteneryPojo customisePackageItenaryPojo) {
		return customisePackageItenaryFacade.update(customisePackageItenaryPojo);
	}
	
	
}
