package com.core.coreserver.facade;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.core.coreserver.pojo.CustomerPojoListResponse;
import com.core.coreserver.pojo.CustomerPojoResponse;
import com.core.coreserver.service.CustomerService;

@Component
public class CustomerFacade {

	@Autowired
	CustomerService customerService;

	@Value("${customer.create.success}")
	private String customerCreatedSuccessfully;

	@Value("${customer.update.success}")
	private String updateSuccessfully;

	@Value("${customer.delete.success}")
	private String customerDeleteSuccessfully;

	public CustomerPojoResponse create(CustomerPojo customerPojo) {
		Customer customer = ObjectMapperUtils.map(customerPojo, Customer.class);
		customer = customerService.create(customer);
		customerPojo = ObjectMapperUtils.map(customer, CustomerPojo.class);
		return createDeleteUpdateResponse(customerCreatedSuccessfully, customerPojo);
	}

	private CustomerPojoResponse createDeleteUpdateResponse(String message, CustomerPojo customerPojo) {
		CustomerPojoResponse customerPojoResponse = new CustomerPojoResponse();
		ResponseMessagePojo responseMessagePojo = new ResponseMessagePojo();
		List<ResponseMessagePojo> successMessages = new ArrayList<>();
		responseMessagePojo.setMessage(message);
		responseMessagePojo.setStatus(HttpStatus.OK);
		successMessages.add(responseMessagePojo);
		customerPojoResponse.setSuccessMessaages(successMessages);
		return customerPojoResponse;
	}

	public CustomerPojoListResponse get() {
		CustomerPojoListResponse customerPojoListResponse = new CustomerPojoListResponse();
		List<User> customerEntity = customerService.getAll();
		List<CustomerPojo> customerPojo = ObjectMapperUtils.mapAll(customerEntity, CustomerPojo.class);
		customerPojoListResponse.setCustomerPojo(customerPojo);
		return customerPojoListResponse;
	}

	public CustomerPojoResponse update(CustomerPojo customerPojo) {
		User userEntity = customerService.findById(customerPojo.getId());
		ObjectMapperUtils.map(customerPojo, userEntity);
		userEntity = customerService.update(userEntity);
		customerPojo = ObjectMapperUtils.map(userEntity, CustomerPojo.class);
		return createDeleteUpdateResponse(updateSuccessfully, customerPojo);

	}

	public CustomerPojoResponse delete(long id) {
		User userEntity = customerService.findById(id);
		customerService.delete(userEntity);
		return createDeleteUpdateResponse(customerDeleteSuccessfully, null);
	}

}
