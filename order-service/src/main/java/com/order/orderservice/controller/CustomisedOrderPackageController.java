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

import com.order.orderservice.facade.CustomisedOrderPackageFacade;
import com.tourcoreservice.pojo.orders.CustomisedOrderPackagePojo;
import com.tourcoreservice.response.orders.CustomisePackagePojoListResponse;
import com.tourcoreservice.response.orders.CustomisePackagePojoRespone;
import com.tourcoreservice.response.orders.CustomisedPartialOrderPackagePojoResponse;

@RestController
@RequestMapping("/custamise-package")
public class CustomisedOrderPackageController {

	@Autowired
	private CustomisedOrderPackageFacade customisePackageFacade;

	@PostMapping
	public CustomisePackagePojoRespone createCustomisePackage(@RequestBody CustomisedOrderPackagePojo customisePackagePojo) {
		return customisePackageFacade.create(customisePackagePojo);

	}

	@GetMapping
	public CustomisePackagePojoListResponse getAllCustomisePackage() {
		return customisePackageFacade.listAll();
	}

	@GetMapping("/{id}")
	public CustomisePackagePojoRespone getCustomisePackageById(@PathVariable Long id) {
		return customisePackageFacade.getData(id);
	}

	@GetMapping("/byuserid/{userid}")
	public CustomisedPartialOrderPackagePojoResponse getCustomisePackageByuserid(@PathVariable String userid) {
		return customisePackageFacade.getbyuserid(userid);
	}
	
	@GetMapping("/byemployemail/{employemail}")
	public CustomisedPartialOrderPackagePojoResponse getCustomisedPackageByEmployid(@PathVariable String employemail) {
		return customisePackageFacade.getByemployid(employemail);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		customisePackageFacade.delete(id);
	}

	@PutMapping
	public CustomisePackagePojoRespone updateCustomisePackageById(@RequestBody CustomisedOrderPackagePojo customisePackagePojo) {
		return customisePackageFacade.update(customisePackagePojo);
	}
	
	@PutMapping("/orderid/{id}/{orderid}")
	public CustomisePackagePojoRespone updateorderid(@PathVariable Long id,@PathVariable String orderid) {
		return customisePackageFacade.updateOrderid(id,orderid);
	}
	
	@PutMapping("/status/{id}/{status}")
	public CustomisePackagePojoRespone updatestatus(@PathVariable Long id,@PathVariable Long status) {
		return customisePackageFacade.updatestatus(id,status);
	}
	
	@PutMapping("/acceptedby/{orderid}/{empid}")
	public CustomisePackagePojoRespone updateacceptedby(@PathVariable String empid,@PathVariable Long orderid) {
		return customisePackageFacade.updateacceptedby(empid,orderid);
	}
}