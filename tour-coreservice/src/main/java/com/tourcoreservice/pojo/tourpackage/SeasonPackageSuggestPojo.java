package com.tourcoreservice.pojo.tourpackage;

import com.tourcoreservice.entity.Place;

public class SeasonPackageSuggestPojo {

	private long id;
	private String name;
	private String season;
	private Place place;
	private String type;
	private int price;
	private int maxPrice;
	private long days;
	private String imgcdn;
	private long packId;
	
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
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public Place getPlace() {
		return place;
	}
	public void setPlace(Place place) {
		this.place = place;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getMaxPrice() {
		return maxPrice;
	}
	public void setMaxPrice(int maxPrice) {
		this.maxPrice = maxPrice;
	}
	public long getDays() {
		return days;
	}
	public void setDays(long days) {
		this.days = days;
	}
	public String getImgcdn() {
		return imgcdn;
	}
	public void setImgcdn(String imgcdn) {
		this.imgcdn = imgcdn;
	}
	public long getPackId() {
		return packId;
	}
	public void setPackId(long packId) {
		this.packId = packId;
	}
	
	
	

}
