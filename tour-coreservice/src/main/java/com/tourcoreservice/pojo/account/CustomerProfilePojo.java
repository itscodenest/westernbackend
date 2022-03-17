
package com.tourcoreservice.pojo.account;

import com.tourcoreservice.entity.Travellers;

public class CustomerProfilePojo {
	
	private long id;
	private String name;
	private String birthday;
	private String gender;
	private String maritalstatus;
	private String email;
	private String number;
	private String payableamount;
	private String paidamont;
	private String numoftours;
	private String numberofevents;
	private String numberofactivities;
	private Travellers traveller;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getMaritalstatus() {
		return maritalstatus;
	}
	public void setMaritalstatus(String maritalstatus) {
		this.maritalstatus = maritalstatus;
	}
	public String getPayableamount() {
		return payableamount;
	}
	public void setPayableamount(String payableamount) {
		this.payableamount = payableamount;
	}
	public String getPaidamont() {
		return paidamont;
	}
	public void setPaidamont(String paidamont) {
		this.paidamont = paidamont;
	}
	public String getNumoftours() {
		return numoftours;
	}
	public void setNumoftours(String numoftours) {
		this.numoftours = numoftours;
	}
	public String getNumberofevents() {
		return numberofevents;
	}
	public void setNumberofevents(String numberofevents) {
		this.numberofevents = numberofevents;
	}
	public String getNumberofactivities() {
		return numberofactivities;
	}
	public void setNumberofactivities(String numberofactivities) {
		this.numberofactivities = numberofactivities;
	}
	public Travellers getTraveller() {
		return traveller;
	}
	public void setTraveller(Travellers traveller) {
		this.traveller = traveller;
	}
	
	
	

}
