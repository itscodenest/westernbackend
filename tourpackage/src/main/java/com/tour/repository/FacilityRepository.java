package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tour.entity.Facility;

@Repository
public interface FacilityRepository extends JpaRepository<Facility, Long>{

}
