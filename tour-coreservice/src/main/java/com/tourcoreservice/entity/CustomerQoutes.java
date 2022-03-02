package com.tourcoreservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class CustomerQoutes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String coverImage;
	private String coverHeading;
	private String custumerName;
	private String mobileNum;
	private String departure;
	private String destination;
	private String transport;
	private String roomType;
	private String adults;
	private String children;
	private String infant;
	private String custEmail;
	private String travdate;
	private String duration;
	private String totalcost;
	private long userId;
	private long status;
	private int agentStatus;
	private boolean isflight;
	private boolean ishotel;
	private long orderId;
	private String createddate;
	private String updateddate;
	private String createrby;
	private String updatedby;

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

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerqoute_flight")
	private List<CustomisedOrderPackageFlightinfo> CustomerQoutesFlight;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerqoute_hotel")
	private List<CustomisedOrderPackageHotelInfo> customerQoutesHotel;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerqoute_iternry")
	private List<CustomisedOrderPackageIternery> customerQoutesiternery;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(String coverImage) {
		this.coverImage = coverImage;
	}

	public String getCoverHeading() {
		return coverHeading;
	}

	public void setCoverHeading(String coverHeading) {
		this.coverHeading = coverHeading;
	}

	public String getCustumerName() {
		return custumerName;
	}

	public void setCustumerName(String custumerName) {
		this.custumerName = custumerName;
	}

	public String getMobileNum() {
		return mobileNum;
	}

	public void setMobileNum(String mobileNum) {
		this.mobileNum = mobileNum;
	}

	public String getDeparture() {
		return departure;
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

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	
	public int getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(int agentStatus) {
		this.agentStatus = agentStatus;
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

	public String getCreaterby() {
		return createrby;
	}

	public String getUpdatedby() {
		return updatedby;
	}

	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}

	public void setCreaterby(String createrby) {
		this.createrby = createrby;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getAdults() {
		return adults;
	}

	public void setAdults(String adults) {
		this.adults = adults;
	}

	public String getChildren() {
		return children;
	}

	public void setChildren(String children) {
		this.children = children;
	}

	public String getInfant() {
		return infant;
	}

	public void setInfant(String infant) {
		this.infant = infant;
	}

	public String getCustEmail() {
		return custEmail;
	}

	public void setCustEmail(String custEmail) {
		this.custEmail = custEmail;
	}

	public String getTravdate() {
		return travdate;
	}

	
	
	public void setTravdate(String travdate) {
		this.travdate = travdate;
	}

	
	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
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

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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

	public List<CustomisedOrderPackageFlightinfo> getCustomerQoutesFlight() {
		return CustomerQoutesFlight;
	}

	public void setCustomerQoutesFlight(List<CustomisedOrderPackageFlightinfo> customerQoutesFlight) {
		CustomerQoutesFlight = customerQoutesFlight;
	}

	public List<CustomisedOrderPackageHotelInfo> getCustomerQoutesHotel() {
		return customerQoutesHotel;
	}

	public void setCustomerQoutesHotel(List<CustomisedOrderPackageHotelInfo> customerQoutesHotel) {
		this.customerQoutesHotel = customerQoutesHotel;
	}

	public List<CustomisedOrderPackageIternery> getCustomerQoutesiternery() {
		return customerQoutesiternery;
	}

	public void setCustomerQoutesiternery(List<CustomisedOrderPackageIternery> customerQoutesiternery) {
		this.customerQoutesiternery = customerQoutesiternery;
	}

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
	}
	
	

}
