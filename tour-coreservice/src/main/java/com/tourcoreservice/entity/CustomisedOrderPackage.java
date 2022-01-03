package com.tourcoreservice.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class CustomisedOrderPackage {

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

	private long userId;
	private long status;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "flightinfo_id")
	private Set<CustomisedOrderPackageFlightinfo> flightInfo;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "hotelinfo_id")
	private Set<CustomisedOrderPackageHotelInfo> hotel_info;
	
	private String totalPrice;

	@Lob
	private String inclusiontext;
	@Lob
	private String exlusionText;
	@Lob
	private String paymentPolicy;
	@Lob
	private String termsandconditions;
	@Lob
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

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

}
