package com.account.accountservice.facade;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import com.account.accountservice.service.CustomerService;
import com.tourcoreservice.account.pojo.CustomerPojo;
import com.tourcoreservice.account.response.CustomerPojoListResponse;
import com.tourcoreservice.account.response.CustomerPojoResponse;
import com.tourcoreservice.entity.Address;
import com.tourcoreservice.entity.Customer;
import com.tourcoreservice.entity.Role;
import com.tourcoreservice.entity.User;
import com.tourcoreservice.generic.pojo.ResponseMessagePojo;
import com.tourcoreservice.util.ObjectMapperUtils;

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
		customerPojoResponse.setCustomerPojo(customerPojo);
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
		deleteExistingRoles(userEntity, userEntity.getRoles());
		deleteExistingAddresses(userEntity, userEntity.getAddresses());
		ObjectMapperUtils.map(customerPojo, userEntity);
		userEntity = customerService.update(userEntity);
		customerPojo = ObjectMapperUtils.map(userEntity, CustomerPojo.class);
		return createDeleteUpdateResponse(updateSuccessfully, customerPojo);

	}

	private void deleteExistingAddresses(User user, Set<Address> addresses) {
		user.getAddresses().removeAll(addresses);
		customerService.save(user);
	}

	private void deleteExistingRoles(User user, List<Role> roles) {
		user.getRoles().removeAll(roles);
		customerService.save(user);
	}

	public CustomerPojoResponse delete(long id) {
		User userEntity = customerService.findById(id);
		customerService.delete(userEntity);
		return createDeleteUpdateResponse(customerDeleteSuccessfully, null);
	}

	public CustomerPojoResponse getCustomerById(long customerId) {
		User userEntity = customerService.findById(customerId);
		CustomerPojo customerPojo = ObjectMapperUtils.map(userEntity, CustomerPojo.class);
		return createDeleteUpdateResponse("", customerPojo);
	}

}
