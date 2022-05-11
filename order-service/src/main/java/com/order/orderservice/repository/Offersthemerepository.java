package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Offerstheme;

@Repository
public interface Offersthemerepository extends JpaRepository<Offerstheme, Long>{

//	@Query(value="SELECT * FROM offerstheme as a,traveloffers as t where t.themeid=:themeid and t.themeid=a.themeid",nativeQuery=true)
//	List<Offerstheme> findAllBythemeId(@Param("themeid") Long themeid);

	Offerstheme findById(long themeid);

	Offerstheme findByThemename(String themename);
	
	
}

