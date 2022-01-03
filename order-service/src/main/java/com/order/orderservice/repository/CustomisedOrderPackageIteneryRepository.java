package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisedOrderPackageIternery;

@Repository
public interface CustomisedOrderPackageIteneryRepository extends JpaRepository<CustomisedOrderPackageIternery, Long>{

}
