package com.tour.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tourcoreservice.entity.BudgetPackageSuggest;

public interface BudgetPackageSuggestRepository extends JpaRepository<BudgetPackageSuggest, Long> {
	BudgetPackageSuggest findById(long id);

	List<BudgetPackageSuggest> findByBudget(String budget);
}
