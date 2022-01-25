package com.tourcoreservice.pojo.orders;

import java.util.Date;

public class CustomisedOrderPackageFlightinfoPojo {

	private long id;

	
	private String flightDepartureCity;

	private String flightArrivalCity;

	private String baggageCheckinCapacity;

	private String baggageCabinCapacity;

	private Date departureDate;

	private String departureTime;

	private Date arrivalDate;

	private String arrivalTime;

	private String Members;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	public String getFlightDepartureCity() {
		return flightDepartureCity;
	}

	public void setFlightDepartureCity(String flightDepartureCity) {
		this.flightDepartureCity = flightDepartureCity;
	}

	public String getFlightArrivalCity() {
		return flightArrivalCity;
	}

	public void setFlightArrivalCity(String flightArrivalCity) {
		this.flightArrivalCity = flightArrivalCity;
	}

	public String getBaggageCheckinCapacity() {
		return baggageCheckinCapacity;
	}

	public void setBaggageCheckinCapacity(String baggageCheckinCapacity) {
		this.baggageCheckinCapacity = baggageCheckinCapacity;
	}

	public String getBaggageCabinCapacity() {
		return baggageCabinCapacity;
	}

	public void setBaggageCabinCapacity(String baggageCabinCapacity) {
		this.baggageCabinCapacity = baggageCabinCapacity;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public Date getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(Date arrivalDate) {
		this.arrivalDate = arrivalDate;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getMembers() {
		return Members;
	}

	public void setMembers(String members) {
		Members = members;
	}

	
}
