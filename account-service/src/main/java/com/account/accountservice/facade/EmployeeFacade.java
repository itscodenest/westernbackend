package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.service.EmployeeService;
import com.tourcoreservice.account.pojo.EmployeePojo;
import com.tourcoreservice.account.response.EmployeePojoListResponse;
import com.tourcoreservice.account.response.EmployeePojoResponse;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.Employee;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.generic.pojo.ResponseMessagePojo;
import com.tourcoreservice.util.ObjectMapperUtils;

@Component
public class EmployeeFacade {

	@Autowired
	EmployeeService employeeService;

	@Value("${employee.created.success}")
	private String employeeCreated;

	@Value("${employee.updated.success}")
	private String employeeUpdated;

	@Value("${employee.deleted.success}")
	private String employeeDeletedSuccessfully;

	public EmployeePojoResponse create(EmployeePojo employeePojo) {
		Employee employee = ObjectMapperUtils.map(employeePojo, Employee.class);
		employee = employeeService.create(employee);
		employeePojo = ObjectMapperUtils.map(employee, EmployeePojo.class);
		return createDeleteUpdateResponse(employeePojo, employeeCreated);
	}

	private EmployeePojoResponse createDeleteUpdateResponse(EmployeePojo employeePojo, String message) {
		EmployeePojoResponse employeePojoResponse = new EmployeePojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		employeePojoResponse.setSuccessMessaages(successMessages);
		return employeePojoResponse;
	}

	public EmployeePojoListResponse getAll() {
		EmployeePojoListResponse employeePojoListResponse = new EmployeePojoListResponse();
		List<User> employeeEntity = employeeService.getAll();
		List<EmployeePojo> employeePojoList = ObjectMapperUtils.mapAll(employeeEntity, EmployeePojo.class);
		employeePojoListResponse.setEmploeePojo(employeePojoList);
		return employeePojoListResponse;
	}

	public EmployeePojoResponse update(EmployeePojo employeePojo) {
		User user = employeeService.findById(employeePojo.getId());
		deleteExistingRoles(user, user.getRoles());
		deleteExistingAddresses(user, user.getAddresses());
		ObjectMapperUtils.map(employeePojo, user);
		user = employeeService.update(user);
		EmployeePojo employee = ObjectMapperUtils.map(user, EmployeePojo.class);
		return createDeleteUpdateResponse(employee, employeeUpdated);
	}

	private void deleteExistingAddresses(User user, Set<Address> addresses) {
		user.getAddresses().removeAll(addresses);
		employeeService.save(user);
	}

	private void deleteExistingRoles(User user, List<Role> roles) {
		user.getRoles().removeAll(roles);
		employeeService.save(user);
	}

	public EmployeePojoResponse delete(long id) {
		User user = employeeService.findById(id);
		employeeService.delete(user);
		return createDeleteUpdateResponse(null, employeeDeletedSuccessfully);
	}

	public EmployeePojoResponse getEmployeeById(long employeeId) {
		User user = employeeService.findById(employeeId);
		EmployeePojo employeePojo = ObjectMapperUtils.map(user, EmployeePojo.class);
		return createDeleteUpdateResponse(employeePojo, "");
	}

}
