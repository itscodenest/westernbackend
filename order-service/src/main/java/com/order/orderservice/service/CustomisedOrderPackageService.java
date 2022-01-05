package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisedOrderPackageRepository;
import com.tourcoreservice.entity.CustomisedOrderPackage;

@Service
public class CustomisedOrderPackageService {

	@Autowired
	private CustomisedOrderPackageRepository customisePackageRepository;

	public CustomisedOrderPackage create(CustomisedOrderPackage customisePackage) {
		return customisePackageRepository.save(customisePackage);
	}

	public List<CustomisedOrderPackage> listAll() {
		return customisePackageRepository.findAll();
	}

	public CustomisedOrderPackage getDataId(Long id) {
		return customisePackageRepository.findById(id).get();
	}

	public void deletePacakge(long id) {
		customisePackageRepository.deleteById(id);

	}

	public CustomisedOrderPackage Update(CustomisedOrderPackage customisePackage) {

		return customisePackageRepository.save(customisePackage);
	}

}