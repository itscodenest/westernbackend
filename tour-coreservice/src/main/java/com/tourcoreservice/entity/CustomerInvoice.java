package com.tourcoreservice.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity 
public class CustomerInvoice {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String travellername;
	private String travelleremail;
	private String travellerphone;
	private String travellerlocation;
	private String travelldate;
	private String currency;
	private String pricewithtax;
	private String moreInfo;
	private String Invoiceheading;
	private long userId;
	private long status;
	private long orderId;
	private boolean isproforma;
	private String invoicenumber;
	private String createddate;
	private String updateddate;
	private String createrby;
	private String updatedby;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<CustomerscheduledPaymets> paymets;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTravellername() {
		return travellername;
	}
	public void setTravellername(String travellername) {
		this.travellername = travellername;
	}
	public String getTravelleremail() {
		return travelleremail;
	}
	public void setTravelleremail(String travelleremail) {
		this.travelleremail = travelleremail;
	}
	
	
	public String getInvoiceheading() {
		return Invoiceheading;
	}
	public void setInvoiceheading(String invoiceheading) {
		Invoiceheading = invoiceheading;
	}
	public boolean isIsproforma() {
		return isproforma;
	}
	public void setIsproforma(boolean isproforma) {
		this.isproforma = isproforma;
	}
	public String getTravellerphone() {
		return travellerphone;
	}
	public void setTravellerphone(String travellerphone) {
		this.travellerphone = travellerphone;
	}
	public String getTravellerlocation() {
		return travellerlocation;
	}
	public void setTravellerlocation(String travellerlocation) {
		this.travellerlocation = travellerlocation;
	}
	public String getTravelldate() {
		return travelldate;
	}
	public void setTravelldate(String travelldate) {
		this.travelldate = travelldate;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getPricewithtax() {
		return pricewithtax;
	}
	public void setPricewithtax(String pricewithtax) {
		this.pricewithtax = pricewithtax;
	}
	public long getUserId() {
		return userId;
	}
	
	
	public String getInvoicenumber() {
		return invoicenumber;
	}
	public void setInvoicenumber(String invoicenumber) {
		this.invoicenumber = invoicenumber;
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
	public long getOrderId() {
		return orderId;
	}
	public void setOrderId(long orderId) {
		this.orderId = orderId;
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
	public String getCreaterby() {
		return createrby;
	}
	public void setCreaterby(String createrby) {
		this.createrby = createrby;
	}
	public String getUpdatedby() {
		return updatedby;
	}
	public void setUpdatedby(String updatedby) {
		this.updatedby = updatedby;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public Set<CustomerscheduledPaymets> getPaymets() {
		return paymets;
	}
	public void setPaymets(Set<CustomerscheduledPaymets> paymets) {
		this.paymets = paymets;
	}
	
	
	
}
