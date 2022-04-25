package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.OffersRepository;
import com.tourcoreservice.entity.Offers;

@Service
public class OffersService {
	
	@Autowired
	OffersRepository offersRepository;
	
	public Offers save(Offers offers) {
		return offersRepository.save(offers);
	}

	public Offers update(Offers Offers, long id) {
		Offers.setId(id);
		return offersRepository.save(Offers);
	}

	public void delete(long travelid) {
		offersRepository.deleteById(travelid);
	}

	public Offers gettraveldetails(long travelid) {
		return offersRepository.findById(travelid);
	}

	public List<Offers> getall(){
		return offersRepository.findAll();
	}
	

}
