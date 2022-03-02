package com.tourcoreservice.pojo.orders;

import java.util.List;

public class CustomerVouchersPojo {

	private long id;

	private String Arrangement;
	private String confirmationNote;
	private String confirmationNum;
	private String moredetails;
	private long customerid;
	private long orderid;
	private String createddate;
	private String createrby;
	private List<CustomerVoucherMemberDetailsPojo> cVoucherMemberDetails;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getArrangement() {
		return Arrangement;
	}
	public void setArrangement(String arrangement) {
		Arrangement = arrangement;
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
	public List<CustomerVoucherMemberDetailsPojo> getcVoucherMemberDetails() {
		return cVoucherMemberDetails;
	}
	public void setcVoucherMemberDetails(List<CustomerVoucherMemberDetailsPojo> cVoucherMemberDetails) {
		this.cVoucherMemberDetails = cVoucherMemberDetails;
	}
	public long getCustomerid() {
		return customerid;
	}
	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
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
