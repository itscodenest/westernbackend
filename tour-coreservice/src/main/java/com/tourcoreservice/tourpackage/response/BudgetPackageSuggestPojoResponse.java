package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.BudgetPackageSuggestPojo;

public class BudgetPackageSuggestPojoResponse  extends AbstractPojoResponse{
	BudgetPackageSuggestPojo budgetBasedPackagePojo;

	public BudgetPackageSuggestPojo getBudgetBasedPackagePojo() {
		return budgetBasedPackagePojo;
	}

	public void setBudgetBasedPackagePojo(BudgetPackageSuggestPojo budgetBasedPackagePojo) {
		this.budgetBasedPackagePojo = budgetBasedPackagePojo;
	}

}
