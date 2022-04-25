package com.tourcoreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Offers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String activityname;
	private String heading;
	private String couponcode;
	private String referencelink;
	private String description;
	@Lob
	private String image;

	@ManyToOne
	@JoinColumn(name = "themeid",nullable=false)
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
