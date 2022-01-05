package com.tourcoreservice.pojo.orders;

import java.util.Date;
import java.util.Set;

import com.tourcoreservice.entity.CustomisedOrderPackageFlightinfo;
import com.tourcoreservice.entity.CustomisedOrderPackageHotelInfo;
import com.tourcoreservice.entity.User;

public class CustomisedOrderPackagePojo {

	private long id;

	private String departureCity;

	private String destination;

	private String mobileNo;

	private String transport;

	private String category;

	private int adults;

	private int children;

	private int infants;

	private String email;

	private Date travelDate;

	private String travelDuration;

	private User user;

	private Set<CustomisedOrderPackageFlightinfo> flightInfo;

	private Set<CustomisedOrderPackageHotelInfo> hotel_info;
	

	private String totalPrice;

	private String inclusiontext;

	private String exlusionText;

	private String paymentPolicy;

	private String termsandconditions;

	private String aditionalinfo;

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

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CustomisedOrderPackageFlightinfo> getFlightInfo() {
		return flightInfo;
	}

	public void setFlightInfo(Set<CustomisedOrderPackageFlightinfo> flightInfo) {
		this.flightInfo = flightInfo;
	}

	public Set<CustomisedOrderPackageHotelInfo> getHotel_info() {
		return hotel_info;
	}

	public void setHotel_info(Set<CustomisedOrderPackageHotelInfo> hotel_info) {
		this.hotel_info = hotel_info;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getInclusiontext() {
		return inclusiontext;
	}

	public void setInclusiontext(String inclusiontext) {
		this.inclusiontext = inclusiontext;
	}

	public String getExlusionText() {
		return exlusionText;
	}

	public void setExlusionText(String exlusionText) {
		this.exlusionText = exlusionText;
	}

	public String getPaymentPolicy() {
		return paymentPolicy;
	}

	public void setPaymentPolicy(String paymentPolicy) {
		this.paymentPolicy = paymentPolicy;
	}

	public String getTermsandconditions() {
		return termsandconditions;
	}

	public void setTermsandconditions(String termsandconditions) {
		this.termsandconditions = termsandconditions;
	}

	public String getAditionalinfo() {
		return aditionalinfo;
	}

	public void setAditionalinfo(String aditionalinfo) {
		this.aditionalinfo = aditionalinfo;
	}

}
