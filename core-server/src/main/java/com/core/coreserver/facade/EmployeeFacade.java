package com.core.coreserver.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.core.coreserver.pojo.EmployeePojoListResponse;
import com.core.coreserver.pojo.EmployeePojoResponse;
import com.core.coreserver.service.EmployeeService;
import com.tourcoreservice.account.pojo.EmployeePojo;
import com.tourcoreservice.entity.Employee;
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
		ObjectMapperUtils.map(employeePojo, user);
		user = employeeService.update(user);
		EmployeePojo employee = ObjectMapperUtils.map(user, EmployeePojo.class);
		return createDeleteUpdateResponse(employee, employeeUpdated);
	}

	public EmployeePojoResponse delete(long id) {
		User user = employeeService.findById(id);
		employeeService.delete(user);
		return createDeleteUpdateResponse(null, employeeDeletedSuccessfully);
	}

}
