package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomerPaymentHistoryRepository;
import com.tourcoreservice.entity.CustomerPaymentHistory;

@Service
public class CustomerPaymentHistoryService {
	
	@Autowired
	private CustomerPaymentHistoryRepository cRepository;

	public CustomerPaymentHistory create(CustomerPaymentHistory cPayment) {
		return cRepository.save(cPayment);
	}

	public List<CustomerPaymentHistory> listAll() {
		return cRepository.findAll();
	}

	public CustomerPaymentHistory getDataId(Long id) {
		return cRepository.findById(id).get();
	}

	public void deletePayment(long id) {
		cRepository.deleteById(id);

	}

	public CustomerPaymentHistory Update(CustomerPaymentHistory cHistory) {

		return cRepository.save(cHistory);
	}
	
	public List<CustomerPaymentHistory> listallONcustomer(Long customerid){
		return cRepository.findAllOnCutomers(customerid);
	}
	
	public List<CustomerPaymentHistory> listallOnOrder(Long orderid) {
		return cRepository.findAllOnOrder(orderid);
	}

}
