package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomerInvoiceRepository;
import com.tourcoreservice.entity.CustomerInvoice;

@Service
public class CustomerinvoiceService {
	
	@Autowired
	private CustomerInvoiceRepository cRepository ;

	public CustomerInvoice create(CustomerInvoice cInvoice) {
		return cRepository.save(cInvoice);
	}

	public List<CustomerInvoice> listAll() {
		return cRepository.findAll();
	}

	public CustomerInvoice getDataId(Long id) {
		return cRepository.findById(id).get();
	}

	public void deleteInvoice(long id) {
		cRepository.deleteById(id);

	}

	public CustomerInvoice Update(CustomerInvoice cInvoice) {

		return cRepository.save(cInvoice);
	}

	public List<CustomerInvoice> listallOnOrder(Long orderid) {
		return cRepository.findAllOnOrder(orderid);
	}

	


}
