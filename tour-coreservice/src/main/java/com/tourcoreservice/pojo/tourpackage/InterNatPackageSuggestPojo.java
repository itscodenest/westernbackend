package com.tourcoreservice.pojo.tourpackage;

import com.tourcoreservice.entity.Place;

public class InterNatPackageSuggestPojo {
	private long id;
	private String name;
	private Place place;
	private String startFrom;
	private long maxprice;
	private int days;
	private String imgcdn;
	private long packId;
	
	
	public int getDays() {
		return days;
	}
	
	
	public long getPackId() {
		return packId;
	}


	public void setPackId(long packId) {
		this.packId = packId;
	}


	public void setDays(int days) {
		this.days = days;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getStartFrom() {
		return startFrom;
	}
	public void setStartFrom(String startFrom) {
		this.startFrom = startFrom;
	}
	public long getMaxprice() {
		return maxprice;
	}
	public void setMaxprice(long maxprice) {
		this.maxprice = maxprice;
	}
	public String getImgcdn() {
		return imgcdn;
	}
	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}

	
}
