package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisedOrderPackageFlightinfo;

@Repository
public interface CustomisedOrderPackageFlightinfoRepository extends JpaRepository<CustomisedOrderPackageFlightinfo, Long> {

}
