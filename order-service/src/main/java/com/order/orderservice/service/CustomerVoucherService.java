package com.order.orderservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.order.orderservice.repository.CustomerVoucherRepository;
import com.tourcoreservice.entity.CustomerVoucher;

@Service
public class CustomerVoucherService {
	
	@Autowired
	private CustomerVoucherRepository cRepository;

	public CustomerVoucher create(CustomerVoucher cPayment) {
		return cRepository.save(cPayment);
	}

	public List<CustomerVoucher> listAll() {
		return cRepository.findAll();
	}

	public CustomerVoucher getDataId(Long id) {
		return cRepository.findById(id).get();
	}

	public void deletebyid(long id) {
		cRepository.deleteById(id);

	}

	public CustomerVoucher Update(CustomerVoucher cQoutes) {

		return cRepository.save(cQoutes);
	}
	
	public List<CustomerVoucher> listallONcustomer(String id){
		return cRepository.findAllOnCutomers(id);
	}
	
	public List<CustomerVoucher> listallOnOrder(Long orderid) {
		return cRepository.findAllOnOrder(orderid);
	}

	
}
