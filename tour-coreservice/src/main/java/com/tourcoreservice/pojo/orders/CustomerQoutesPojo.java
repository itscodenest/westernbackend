package com.tourcoreservice.pojo.orders;

import java.util.List;

public class CustomerQoutesPojo {
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
	private String inclusiontext;
	private String exlusionText;
	private String paymentPolicy;
	private String termsandconditions;
	private String aditionalinfo;
	private String totalcost;
	// need to connect with order table
	private long orderId;
	private String createddate;
	private String updateddate;
	// need to connect with user table
	private String userId;
	private long status;
	private int agentStatus;
	// need to connect with user table
	private String createrby;
	private String updatedby;

	private List<CustomisedOrderPackageFlightinfoPojo> customerQoutesFlight;
	private List<CustomisedOrderPackageHotelInfoPojo> customerQoutesHotel;
	private List<CustomisedOrderPackageIteneryPojo> customerQoutesiternery;

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

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(String totalcost) {
		this.totalcost = totalcost;
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

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	
	

	public int getAgentStatus() {
		return agentStatus;
	}

	public void setAgentStatus(int agentStatus) {
		this.agentStatus = agentStatus;
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

	public String getPaymentPolicy() {
		return paymentPolicy;
	}

	

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public String getUpdateddate() {
		return updateddate;
	}

	public void setUpdateddate(String updateddate) {
		this.updateddate = updateddate;
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

	public List<CustomisedOrderPackageFlightinfoPojo> getCustomerQoutesFlight() {
		return customerQoutesFlight;
	}

	public void setCustomerQoutesFlight(List<CustomisedOrderPackageFlightinfoPojo> customerQoutesFlight) {
		this.customerQoutesFlight = customerQoutesFlight;
	}

	public List<CustomisedOrderPackageHotelInfoPojo> getCustomerQoutesHotel() {
		return customerQoutesHotel;
	}

	public void setCustomerQoutesHotel(List<CustomisedOrderPackageHotelInfoPojo> customerQoutesHotel) {
		this.customerQoutesHotel = customerQoutesHotel;
	}

	public List<CustomisedOrderPackageIteneryPojo> getCustomerQoutesiternery() {
		return customerQoutesiternery;
	}

	public void setCustomerQoutesiternery(List<CustomisedOrderPackageIteneryPojo> customerQoutesiternery) {
		this.customerQoutesiternery = customerQoutesiternery;
	}

}
