package com.tourcoreservice.entity.events;

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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.tourcoreservice.entity.Asset;

@Entity
public class EventArtist {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String name;
	private String email;
	private String phone;
	private String address;
	private String socialmedia1;
	private String socialmedia2;
	private String coverimage;
	private String discription;
	
//	private Set<String> aadhar;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSocialmedia1() {
		return socialmedia1;
	}

	public void setSocialmedia1(String socialmedia1) {
		this.socialmedia1 = socialmedia1;
	}

	public String getSocialmedia2() {
		return socialmedia2;
	}

	public void setSocialmedia2(String socialmedia2) {
		this.socialmedia2 = socialmedia2;
	}

	
	public String getCoverimage() {
		return coverimage;
	}

	public void setCoverimage(String coverimage) {
		this.coverimage = coverimage;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

//	public Set<String> getAadhar() {
//		return aadhar;
//	}
//
//	public void setAadhar(Set<String> aadhar) {
//		this.aadhar = aadhar;
//	}

	

}
