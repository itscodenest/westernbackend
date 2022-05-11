package com.order.orderservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Offers;
import com.tourcoreservice.entity.Offerstheme;

@Repository
public interface OffersRepository extends JpaRepository<Offers, Long> {

	Offers findById(long id);

	List<Offers> findAllByOfferstheme(Offerstheme offerstheme);
}
