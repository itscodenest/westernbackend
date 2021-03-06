package com.account.accountservice.controller;

import java.lang.reflect.InvocationTargetException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.accountservice.facade.UserFacade;
import com.tourcoreservice.pojo.account.UserPojo;
import com.tourcoreservice.response.account.UserPojoListResponse;
import com.tourcoreservice.response.account.UserPojoResponse;

@RestController
@RequestMapping("/user")
public class UserRestController {

	@Autowired
	private UserFacade userFacade;

	@PostMapping
	public UserPojoResponse create(@RequestBody UserPojo userPojo) {
		return userFacade.create(userPojo);
	}

	@GetMapping
	public UserPojoListResponse getAll() {
		return userFacade.listAll();
	}

	@GetMapping("/{id}")
	public UserPojoResponse getUserById(@PathVariable long id) throws InvocationTargetException {
		return userFacade.getById(id);
	}
	
	@GetMapping("byusername/{username}")
	public UserPojoResponse getUserById(@PathVariable String username) throws InvocationTargetException {
		return userFacade.getByuserName(username);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		userFacade.delete(id);
	}

	@PutMapping("/{id}")
	public UserPojoResponse update(@RequestBody UserPojo userPojo, @PathVariable("id") long id) {
		userPojo.setId(id);
		return userFacade.update(userPojo);
	}

	@GetMapping("/internaldmc")
	public UserPojoListResponse getAllInternalDMC() {
		return userFacade.getAllInternalDMC();
	}

}
