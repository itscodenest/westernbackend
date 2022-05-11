package com.tourcoreservice.response.tourpackage;

import java.util.List;

import com.tourcoreservice.pojo.generic.AbstractPojoResponse;
import com.tourcoreservice.pojo.tourpackage.TravelBlogPartialpojo;
import com.tourcoreservice.pojo.tourpackage.TravelBlogsPojo;

public class Blogpojoresponse extends AbstractPojoResponse {

	private TravelBlogsPojo travelBlogsPojo;
	private TravelBlogPartialpojo partialpojo;
	private List<TravelBlogPartialpojo> partialPojoBlogs;
	
	
	public TravelBlogsPojo getTravelBlogsPojo() {
		return travelBlogsPojo;
	}
	public void setTravelBlogsPojo(TravelBlogsPojo travelBlogsPojo) {
		this.travelBlogsPojo = travelBlogsPojo;
	}
	public TravelBlogPartialpojo getPartialpojo() {
		return partialpojo;
	}
	public void setPartialpojo(TravelBlogPartialpojo partialpojo) {
		this.partialpojo = partialpojo;
	}
	public List<TravelBlogPartialpojo> getPartialPojoBlogs() {
		return partialPojoBlogs;
	}
	public void setPartialPojoBlogs(List<TravelBlogPartialpojo> partialPojoBlogs) {
		this.partialPojoBlogs = partialPojoBlogs;
	}
	
	

}
