package com.tourcoreservice.tourpackage.response;

import java.util.List;

import com.tourcoreservice.generic.pojo.AbstractPojoResponse;
import com.tourcoreservice.tourpackage.pojo.CategoryPojo;

public class CategoryListResponse extends AbstractPojoResponse{

	List<CategoryPojo> categoryPojo;

	public List<CategoryPojo> getCategoryPojo() {
		return categoryPojo;
	}

	public void setCategoryPojo(List<CategoryPojo> categoryPojo) {
		this.categoryPojo = categoryPojo;
	} 
	
}
