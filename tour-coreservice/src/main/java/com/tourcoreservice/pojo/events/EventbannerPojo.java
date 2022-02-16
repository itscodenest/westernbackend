package com.tourcoreservice.pojo.events;

import javax.persistence.Lob;

public class EventbannerPojo {

	private long id;
	@Lob
	private String image;
	private String gcsurl;
	private String heading;
	private String discription;
	private String date;
	private String month;
	private String eventid;
	private Boolean isActive;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getGcsurl() {
		return gcsurl;
	}
	public void setGcsurl(String gcsurl) {
		this.gcsurl = gcsurl;
	}
	public String getHeading() {
		return heading;
	}
	public void setHeading(String heading) {
		this.heading = heading;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getEventid() {
		return eventid;
	}
	public void setEventid(String eventid) {
		this.eventid = eventid;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
