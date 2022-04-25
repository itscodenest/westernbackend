package com.order.orderservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Offers;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Long> {

	Offers findById(long id);
}
