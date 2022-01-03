package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisedOrderPackageFlightinfoRepository;
import com.tourcoreservice.entity.CustomisedOrderPackageFlightinfo;

@Service
public class CustomisedOrderPackageFlightinfoService {

	@Autowired
	private CustomisedOrderPackageFlightinfoRepository customisePackageFlightinfoRepository;

	public CustomisedOrderPackageFlightinfo create(CustomisedOrderPackageFlightinfo customisePackageFlightinfo) {
		return customisePackageFlightinfoRepository.save(customisePackageFlightinfo);
	}

	public List<CustomisedOrderPackageFlightinfo> listAll() {
		return customisePackageFlightinfoRepository.findAll();
	}

	public CustomisedOrderPackageFlightinfo getById(Long id) {
		return customisePackageFlightinfoRepository.findById(id).get();
	}

	public void deleteCustomisePackageFlightinfo(long id) {
		customisePackageFlightinfoRepository.deleteById(id);

	}

	public CustomisedOrderPackageFlightinfo Update(CustomisedOrderPackageFlightinfo customisePackageFlightinfo) {
		return customisePackageFlightinfoRepository.save(customisePackageFlightinfo);
	}

}
