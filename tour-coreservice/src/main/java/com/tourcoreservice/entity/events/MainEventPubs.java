package com.tourcoreservice.entity.events;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class MainEventPubs {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String smallDiscription;
	@Lob
	private String discription;
	private String address;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
	@JoinColumn(name = "Publocation_id")
	private EventCityLocation place;
	private String map;
	private String image;
	private boolean isfood;
	private boolean isdrink;
	private boolean isparking;
	private boolean ismusic;
	private boolean isgarden;
	private boolean isActive;
	
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
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public EventCityLocation getPlace() {
		return place;
	}
	public void setPlace(EventCityLocation place) {
		this.place = place;
	}
	public String getMap() {
		return map;
	}
	public void setMap(String map) {
		this.map = map;
	}
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public boolean isIsfood() {
		return isfood;
	}
	public void setIsfood(boolean isfood) {
		this.isfood = isfood;
	}
	public boolean isIsdrink() {
		return isdrink;
	}
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public void setIsdrink(boolean isdrink) {
		this.isdrink = isdrink;
	}
	public boolean isIsparking() {
		return isparking;
	}
	public void setIsparking(boolean isparking) {
		this.isparking = isparking;
	}
	public boolean isIsmusic() {
		return ismusic;
	}
	public void setIsmusic(boolean ismusic) {
		this.ismusic = ismusic;
	}
	public boolean isIsgarden() {
		return isgarden;
	}
	public void setIsgarden(boolean isgarden) {
		this.isgarden = isgarden;
	}
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getSmallDiscription() {
		return smallDiscription;
	}
	public void setSmallDiscription(String smallDiscription) {
		this.smallDiscription = smallDiscription;
	}
	
	

}
