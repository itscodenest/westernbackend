package com.tourcoreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BtoBPaymentHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String discription;
	private float amount;
	private String paidfor;
	private long btobid;
	private String createrid;
	private String createddate;
	private String paidby;
	private boolean status;
	private String modeofpay;
	private long orderid;
	private long userid;
	private String extranote;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDiscription() {
		return discription;
	}
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public String getPaidfor() {
		return paidfor;
	}
	public void setPaidfor(String paidfor) {
		this.paidfor = paidfor;
	}
	public String getExtranote() {
		return extranote;
	}
	public void setExtranote(String extranote) {
		this.extranote = extranote;
	}
	public long getBtobid() {
		return btobid;
	}
	public void setBtobid(long btobid) {
		this.btobid = btobid;
	}
	public String getCreaterid() {
		return createrid;
	}
	public void setCreaterid(String createrid) {
		this.createrid = createrid;
	}
	public String getCreateddate() {
		return createddate;
	}
	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}
	public String getPaidby() {
		return paidby;
	}
	public void setPaidby(String paidby) {
		this.paidby = paidby;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getModeofpay() {
		return modeofpay;
	}
	public void setModeofpay(String modeofpay) {
		this.modeofpay = modeofpay;
	}
	public long getOrderid() {
		return orderid;
	}
	public void setOrderid(long orderid) {
		this.orderid = orderid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	
	
	
}
