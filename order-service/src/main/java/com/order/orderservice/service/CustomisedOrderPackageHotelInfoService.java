package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.CustomisedOrderPackageHotelInfoRepository;
import com.tourcoreservice.entity.CustomisedOrderPackageHotelInfo;

@Service
public class CustomisedOrderPackageHotelInfoService {

	@Autowired
	private CustomisedOrderPackageHotelInfoRepository customisePackageHotelInfoRepository;

	public CustomisedOrderPackageHotelInfo create(CustomisedOrderPackageHotelInfo customisePackageHotelInfo) {
		return customisePackageHotelInfoRepository.save(customisePackageHotelInfo);
	}

	public List<CustomisedOrderPackageHotelInfo> listAll() {
		return customisePackageHotelInfoRepository.findAll();
	}

	public CustomisedOrderPackageHotelInfo getById(Long id) {
		return customisePackageHotelInfoRepository.findById(id).get();
	}

	public void deleteById(long id) {
		customisePackageHotelInfoRepository.deleteById(id);

	}

	public CustomisedOrderPackageHotelInfo Update(CustomisedOrderPackageHotelInfo customisePackageHotelInfo) {
		return customisePackageHotelInfoRepository.save(customisePackageHotelInfo);
	}

}
