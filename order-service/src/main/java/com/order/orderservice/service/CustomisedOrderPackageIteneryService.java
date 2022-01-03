package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisedOrderPackageIteneryRepository;
import com.tourcoreservice.entity.CustomisedOrderPackageIternery;

@Service
public class CustomisedOrderPackageIteneryService {

	@Autowired
	private CustomisedOrderPackageIteneryRepository customisePackageItenaryRepository;

	public CustomisedOrderPackageIternery create(CustomisedOrderPackageIternery customisePackageIternery) {
		return customisePackageItenaryRepository.save(customisePackageIternery);
	}

	public List<CustomisedOrderPackageIternery> listAll() {
		return customisePackageItenaryRepository.findAll();
	}

	public CustomisedOrderPackageIternery getById(Long id) {
		return customisePackageItenaryRepository.findById(id).get();
	}

	public void deleteItenary(long id) {
		customisePackageItenaryRepository.deleteById(id);

	}

	public CustomisedOrderPackageIternery Update(CustomisedOrderPackageIternery customisePackageIternery) {
		return customisePackageItenaryRepository.save(customisePackageIternery);
	}

}
