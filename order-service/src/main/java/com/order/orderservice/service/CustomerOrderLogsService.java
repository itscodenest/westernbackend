package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomerOrderLogsRepository;
import com.tourcoreservice.entity.CustomerOrderLogs;

@Service
public class CustomerOrderLogsService {

	@Autowired
	CustomerOrderLogsRepository logsrepository;

	public CustomerOrderLogs save(CustomerOrderLogs logs) {
		return logsrepository.save(logs);
	}

	public CustomerOrderLogs update(CustomerOrderLogs logs) {
		return logsrepository.save(logs);
	}

	public void delete(long id) {
		logsrepository.deleteById(id);
	}

	public List<CustomerOrderLogs> getordermessages(long order_id) {
		return logsrepository.findAllById(order_id);
	}
	
	public CustomerOrderLogs getDataId(Long id) {
		return logsrepository.findById(id).get();
	}

}
