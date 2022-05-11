package com.tourcoreservice.pojo.tourpackage;
import com.tourcoreservice.entity.Testimonialthemes;

public class Pojotestimonials {
	
	
	private long id;
	private String Name;
	private String Description;
	private String Activities;
	private String image1;
	private String image2;
	private String image3;


	private Testimonialthemes testimonialthemes;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getActivities() {
		return Activities;
	}

	public void setActivities(String activities) {
		Activities = activities;
	}

	public Testimonialthemes getTestimonialthemes() {
		return testimonialthemes;
	}

	public void setTestimonialthemes(Testimonialthemes testimonialthemes) {
		this.testimonialthemes = testimonialthemes;
	}

	public String getImage1() {
		return image1;
	}

	public void setImage1(String image1) {
		this.image1 = image1;
	}

	public String getImage2() {
		return image2;
	}

	public void setImage2(String image2) {
		this.image2 = image2;
	}

	public String getImage3() {
		return image3;
	}

	public void setImage3(String image3) {
		this.image3 = image3;
	}
 

}
