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

import com.core.coreserver.facade.EmployeeFacade;
import com.core.coreserver.pojo.EmployeePojoListResponse;
import com.core.coreserver.pojo.EmployeePojoResponse;

@RestController
@CrossOrigin
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	EmployeeFacade employeeFacade;

	@PostMapping
	public EmployeePojoResponse create(@RequestBody EmployeePojo employeePojo) {
		return employeeFacade.create(employeePojo);

	}

	@GetMapping
	public EmployeePojoListResponse getAll() {
		return employeeFacade.getAll();

	}

	@PutMapping
	public EmployeePojoResponse update(@RequestBody EmployeePojo employeePojo) {
		return employeeFacade.update(employeePojo);

	}

	@DeleteMapping("/{id}")
	public EmployeePojoResponse delete(@PathVariable("id") long Id) {
		return employeeFacade.delete(Id);

	}

}
