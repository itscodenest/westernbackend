package com.order.orderservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.orderservice.repository.Offersthemerepository;
import com.tourcoreservice.entity.Offerstheme;

@Service
public class Offersthemeservice {
	@Autowired
	Offersthemerepository offersthemerepository;

	public Offerstheme save(Offerstheme offerstheme) {

		return offersthemerepository.save(offerstheme);

	}

	public Offerstheme update(Offerstheme offerstheme, long themeid) {
		offerstheme.setThemeid(themeid);
		return offersthemerepository.save(offerstheme);

	}

	public void delete(long themeid) {

		offersthemerepository.deleteById(themeid);

	}

	public Offerstheme getbyid(long themeid) {
		return offersthemerepository.findById(themeid);
	}

	public List<Offerstheme> getall(){
		return offersthemerepository.findAll();
	}
	
}