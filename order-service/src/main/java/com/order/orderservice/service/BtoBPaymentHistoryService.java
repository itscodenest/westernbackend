package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.BtoBPaymentHistoryRepository;
import com.tourcoreservice.entity.BtoBPaymentHistory;

@Service
public class BtoBPaymentHistoryService {
	
	@Autowired
	private BtoBPaymentHistoryRepository cRepository;

	public BtoBPaymentHistory create(BtoBPaymentHistory cPayment) {
		return cRepository.save(cPayment);
	}

	public List<BtoBPaymentHistory> listAll() {
		return cRepository.findAll();
	}

	public BtoBPaymentHistory getDataId(Long id) {
		return cRepository.findById(id).get();
	}

	public void deletePayment(long id) {
		cRepository.deleteById(id);

	}

	public BtoBPaymentHistory Update(BtoBPaymentHistory cHistory) {

		return cRepository.save(cHistory);
	}
	
	public List<BtoBPaymentHistory> listallONcustomer(Long customerid){
		return cRepository.findAllOnCutomers(customerid);
	}
	
	public List<BtoBPaymentHistory> listallOnOrder(Long orderid) {
		return cRepository.findAllOnOrder(orderid);
	}

}
