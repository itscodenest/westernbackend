package com.tourcoreservice.tourpackage.response;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.CategoryPojo;

public class CategoryResponse extends AbstractPojoResponse {

	CategoryPojo categoryPojo;

	public CategoryPojo getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(CategoryPojo categoryPojo) {
		this.categoryPojo = categoryPojo;
	}
}
