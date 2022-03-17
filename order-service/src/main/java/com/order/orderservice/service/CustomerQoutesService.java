package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomerQoutesRepository;
import com.tourcoreservice.entity.CustomerQoutes;

@Service
public class CustomerQoutesService {

	@Autowired
	private CustomerQoutesRepository qoutesRepository;

	public CustomerQoutes create(CustomerQoutes cQoutes) {
		return qoutesRepository.save(cQoutes);
	}

	public List<CustomerQoutes> listAll() {
		return qoutesRepository.findAll();
	}

	public List<CustomerQoutes> listallONcustomer(String customerid){
		return qoutesRepository.findAllOnCutomers(customerid);
	}
	
	public List<CustomerQoutes> listallOnOrder(Long orderid) {
		// TODO Auto-generated method stub
		return qoutesRepository.findAllOnOrder(orderid);
	}
	public CustomerQoutes getDataId(Long id) {
		return qoutesRepository.findById(id).get();
	}

	public void deletePacakge(long id) {
		qoutesRepository.deleteById(id);

	}

	public CustomerQoutes Update(CustomerQoutes cQoutes) {

		return qoutesRepository.save(cQoutes);
	}

	

}
