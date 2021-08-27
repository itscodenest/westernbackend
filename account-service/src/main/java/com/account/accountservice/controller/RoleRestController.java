package com.account.accountservice.controller;

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

import com.account.accountservice.facade.RoleFacade;
import com.tourcoreservice.account.pojo.RolePojo;
import com.tourcoreservice.account.response.RolePojoListResponse;
import com.tourcoreservice.account.response.RolePojoResponse;

@RestController
@RequestMapping("/role")
public class RoleRestController {

	@Autowired
	RoleFacade roleFacade;
	
	@PostMapping
	public RolePojoResponse create(@RequestBody RolePojo rolePojo ) {
		return roleFacade.create(rolePojo);
		
	}
	
	@GetMapping
	public RolePojoListResponse allRoles() {
		return roleFacade.getAllRoles();
	}
	
	@PutMapping
	public RolePojoResponse update(@RequestBody RolePojo rolePojo) {
		return roleFacade.update(rolePojo);	
	}
	
	@DeleteMapping("/{id}")
	public RolePojoResponse delete(@PathVariable("id") long id) {
		return roleFacade.delete(id);
		
	}
	
	@PutMapping("/{roleid}/{priviegeid}")
	public RolePojoResponse addPrivilegeToRole(@PathVariable("roleid") long roleId,@PathVariable("priviegeid") long priviegeId) {
		return roleFacade.addPrivilegeToRole(roleId,priviegeId);
		
	}
	
	@DeleteMapping("/{roleid}/{priviegeid}")
	public RolePojoResponse deletePrivilegeForRole(@PathVariable("roleid") long roleId,@PathVariable("priviegeid") long priviegeId) {
		return roleFacade.deletePrivilegeForRole(roleId,priviegeId);
		
	}
	
	@GetMapping("/getrole/{roleid}")
	public RolePojoResponse getRoleById(@PathVariable("roleid") long roleId) {
		return roleFacade.getRoleById(roleId);
		
	}
}
