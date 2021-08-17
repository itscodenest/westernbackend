package com.core.coreserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.core.coreserver.facade.CustomerFacade;
import com.core.coreserver.pojo.CustomerPojoListResponse;
import com.core.coreserver.pojo.CustomerPojoResponse;

@RestController
@CrossOrigin
@RequestMapping("/customer")
public class CustomerRestController {

	@Autowired
	CustomerFacade customerFacade;

	@PostMapping
	public CustomerPojoResponse create(@RequestBody CustomerPojo customerPojo) {
		return customerFacade.create(customerPojo);

	}

	@GetMapping
	public CustomerPojoListResponse get() {
		return customerFacade.get();

	}

	@PutMapping
	public CustomerPojoResponse update(@RequestBody CustomerPojo customerPojo) {
		return customerFacade.update(customerPojo);
	}

	@DeleteMapping("/{id}")
	public CustomerPojoResponse delete(@PathVariable("id") long id) {
		return customerFacade.delete(id);

	}

}
