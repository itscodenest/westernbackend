package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomerpaymentRepository;
import com.tourcoreservice.entity.CustomerPayment;

@Service
public class CustomerpaymentService {

	@Autowired
	private CustomerpaymentRepository cRepository;

	public CustomerPayment create(CustomerPayment cPayment) {
		return cRepository.save(cPayment);
	}

	public List<CustomerPayment> listAll() {
		return cRepository.findAll();
	}

	public CustomerPayment getDataId(Long id) {
		return cRepository.findById(id).get();
	}

	public void deletePayment(long id) {
		cRepository.deleteById(id);

	}

	public CustomerPayment Update(CustomerPayment cQoutes) {

		return cRepository.save(cQoutes);
	}
	
	public List<CustomerPayment> listallONcustomer(Long customerid){
		return cRepository.findAllOnCutomers(customerid);
	}
	
	public List<CustomerPayment> listallOnOrder(Long orderid) {
		return cRepository.findAllOnOrder(orderid);
	}
}
