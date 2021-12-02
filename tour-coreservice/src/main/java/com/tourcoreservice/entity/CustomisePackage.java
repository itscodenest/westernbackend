package com.tourcoreservice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomisePackage {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "departure_city")
	private String departureCity;

	@Column(name = "destination")
	private String destination;

	@Column(name = "mobileno")
	private String mobileNo;

	@Column(name = "transport")
	private String transport;

	@Column(name = "category")
	private String category;

	private int adults;

	private int children;

	private int infants;

	private String email;

	@Column(name = "travel_date")
	private Date travelDate;

	@Column(name = "travel_duration")
	private String travelDuration;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getAdults() {
		return adults;
	}

	public void setAdults(int adults) {
		this.adults = adults;
	}

	public int getChildren() {
		return children;
	}

	public void setChildren(int children) {
		this.children = children;
	}

	public int getInfants() {
		return infants;
	}

	public void setInfants(int infants) {
		this.infants = infants;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTravelDate() {
		return travelDate;
	}

	public void setTravelDate(Date travelDate) {
		this.travelDate = travelDate;
	}

	public String getTravelDuration() {
		return travelDuration;
	}

	public void setTravelDuration(String travelDuration) {
		this.travelDuration = travelDuration;
	}

}
