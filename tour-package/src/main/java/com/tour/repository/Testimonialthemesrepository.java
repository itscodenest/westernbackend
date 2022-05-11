package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Testimonialthemes;



@Repository
public interface Testimonialthemesrepository extends JpaRepository<Testimonialthemes, Long>{

	
	Testimonialthemes findById(long themeid);

	Testimonialthemes findByThemename(String themename);
	

	
	
}
