package com.account.accountservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.Travellers;

@Repository
public interface TravellersRepository extends JpaRepository<Travellers, Long>{
	Travellers findById(String id);
	
	Travellers getUserByUsername(String username);
	
	
	
}
