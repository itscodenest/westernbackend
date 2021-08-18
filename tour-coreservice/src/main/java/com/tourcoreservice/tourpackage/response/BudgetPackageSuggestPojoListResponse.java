package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.tourpackage.pojo.BudgetPackageSuggestPojo;

public class BudgetPackageSuggestPojoListResponse {
	List<BudgetPackageSuggestPojo> budgetBasedPackagePojo;

	public List<BudgetPackageSuggestPojo> getBudgetBasedPackagePojo() {
		return budgetBasedPackagePojo;
	}

	public void setBudgetBasedPackagePojo(List<BudgetPackageSuggestPojo> budgetBasedPackagePojo) {
		this.budgetBasedPackagePojo = budgetBasedPackagePojo;
	}

	
}
