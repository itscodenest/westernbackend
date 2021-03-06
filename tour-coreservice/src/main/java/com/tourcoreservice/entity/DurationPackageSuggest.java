package com.tourcoreservice.entity;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;

@Entity
public class DurationPackageSuggest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String duration;
	@OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
	@JoinTable(name = "DurationpackageSuggest_place")
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
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