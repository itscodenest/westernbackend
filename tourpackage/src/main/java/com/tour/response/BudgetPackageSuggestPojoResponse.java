package com.tour.response;

import com.tour.pojo.BudgetPackageSuggestPojo;

public class BudgetPackageSuggestPojoResponse  extends AbstractPojoResponse{
	BudgetPackageSuggestPojo budgetBasedPackagePojo;

	public BudgetPackageSuggestPojo getBudgetBasedPackagePojo() {
		return budgetBasedPackagePojo;
	}

	public void setBudgetBasedPackagePojo(BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		this.budgetBasedPackagePojo = budgetBasedPackagePojo;
	}

}
