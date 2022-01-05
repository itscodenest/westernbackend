package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.CustomisedOrderPackageHotelInfo;

@Repository
public interface CustomisedOrderPackageHotelInfoRepository  extends JpaRepository<CustomisedOrderPackageHotelInfo , Long> {

}
