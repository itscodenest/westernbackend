package com.tour.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.IternerneriKeys;
import com.tourcoreservice.entity.Iternery;

@Repository
public interface IterneryRepository extends JpaRepository<Iternery, IternerneriKeys>{
Iternery findById(long id);
}
