package com.tourcoreservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class CustomerVoucher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String arrangement;
	private String confirmationNote;
	private String confirmationNum;
	private String moredetails;
	private String customerid;
	private long orderid;
	private String createddate;
	private String createrby;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "customerdetails")
	private List<CustomerVoucherMemberDetails> cVoucherMemberDetails;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public long getOrderid() {
		return orderid;
	}

	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}

	
	
	public String getArrangement() {
		return arrangement;
	}

	public void setArrangement(String arrangement) {
		this.arrangement = arrangement;
	}

	public String getConfirmationNote() {
		return confirmationNote;
	}

	public void setConfirmationNote(String confirmationNote) {
		this.confirmationNote = confirmationNote;
	}

	public String getConfirmationNum() {
		return confirmationNum;
	}

	public void setConfirmationNum(String confirmationNum) {
		this.confirmationNum = confirmationNum;
	}

	public String getMoredetails() {
		return moredetails;
	}

	public void setMoredetails(String moredetails) {
		this.moredetails = moredetails;
	}

	public List<CustomerVoucherMemberDetails> getcVoucherMemberDetails() {
		return cVoucherMemberDetails;
	}

	public void setcVoucherMemberDetails(List<CustomerVoucherMemberDetails> cVoucherMemberDetails) {
		this.cVoucherMemberDetails = cVoucherMemberDetails;
	}

	
	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getCreaterby() {
		return createrby;
	}

	public void setCreaterby(String createrby) {
		this.createrby = createrby;
	}
	
	
	
	

}
