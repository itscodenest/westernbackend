package com.tourcoreservice.pojo.orders;

import com.tourcoreservice.entity.Offerstheme;

public class OffersPojo {
	
	private long id;
	private String activityname;
	private String heading;
	private String couponcode;
	private String referencelink;
	private String description;
	
	private String image;

	private Offerstheme offerstheme;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getActivityname() {
		return activityname;
	}
	public void setActivityname(String activityname) {
		this.activityname = activityname;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getCouponcode() {
		return couponcode;
	}
	public void setCouponcode(String couponcode) {
		this.couponcode = couponcode;
	}
	
	
	public String getReferencelink() {
		return referencelink;
	}
	public void setReferencelink(String referencelink) {
		this.referencelink = referencelink;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Offerstheme getOfferstheme() {
		return offerstheme;
	}
	public void setOfferstheme(Offerstheme offerstheme) {
		this.offerstheme = offerstheme;
	}
	
	
	


}
