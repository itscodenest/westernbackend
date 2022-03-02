package com.tourcoreservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class CustomisedOrderPackageIternery {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private long id;
	
	private String dayHeading;
	private Date date;
	private String dayPlace;
	@Lob
	private String headingDescription;
	@Lob
	private String description;
	@Lob
	private String note;
	
	private boolean isflight;
	private boolean ishotel;
	private boolean ismeals;
	private boolean istaxi;
	private boolean issightseeing;
	private boolean isactivity;
	private String categories;
	private String imgurl1;
	private String imgurl2;
	private String imgurl3;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDayHeading() {
		return dayHeading;
	}
	public void setDayHeading(String dayHeading) {
		this.dayHeading = dayHeading;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDayPlace() {
		return dayPlace;
	}
	public void setDayPlace(String dayPlace) {
		this.dayPlace = dayPlace;
	}
	public String getHeadingDescription() {
		return headingDescription;
	}
	public void setHeadingDescription(String headingDescription) {
		this.headingDescription = headingDescription;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public boolean isIsflight() {
		return isflight;
	}
	public void setIsflight(boolean isflight) {
		this.isflight = isflight;
	}
	public boolean isIshotel() {
		return ishotel;
	}
	public void setIshotel(boolean ishotel) {
		this.ishotel = ishotel;
	}
	public boolean isIsmeals() {
		return ismeals;
	}
	public void setIsmeals(boolean ismeals) {
		this.ismeals = ismeals;
	}
	public boolean isIstaxi() {
		return istaxi;
	}
	public void setIstaxi(boolean istaxi) {
		this.istaxi = istaxi;
	}
	public boolean isIssightseeing() {
		return issightseeing;
	}
	public void setIssightseeing(boolean issightseeing) {
		this.issightseeing = issightseeing;
	}
	public boolean isIsactivity() {
		return isactivity;
	}
	public void setIsactivity(boolean isactivity) {
		this.isactivity = isactivity;
	}
	public String getCategories() {
		return categories;
	}
	public void setCategories(String categories) {
		this.categories = categories;
	}
	public String getImgurl1() {
		return imgurl1;
	}
	public void setImgurl1(String imgurl1) {
		this.imgurl1 = imgurl1;
	}
	public String getImgurl2() {
		return imgurl2;
	}
	public void setImgurl2(String imgurl2) {
		this.imgurl2 = imgurl2;
	}
	public String getImgurl3() {
		return imgurl3;
	}
	public void setImgurl3(String imgurl3) {
		this.imgurl3 = imgurl3;
	}
	
	
	
}
