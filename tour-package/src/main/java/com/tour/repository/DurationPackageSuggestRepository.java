package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tourcoreservice.entity.DurationPackageSuggest;

@Repository
public interface DurationPackageSuggestRepository extends JpaRepository<DurationPackageSuggest, Long> {
	DurationPackageSuggest findById(long id);

	List<DurationPackageSuggest> findByDuration(String duration);
}
