package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tourcoreservice.entity.Testimonials;
import com.tourcoreservice.entity.Testimonialthemes;



public interface Testimonialsrepository extends JpaRepository<Testimonials, Long> {
	@Query(value="select * from testimonials t where t.theme_id=:themeid",nativeQuery=true)
	List<Testimonials> findAllById(@Param("themeid") Long themeid);

	List<Testimonials> findAllByTestimonialthemes(Testimonialthemes testimonialthemes);


}
