package com.tourcoreservice.entity;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String name;

	private String status;

	@CreatedBy
	private String createdBy;

	@CreatedDate
	private Date createdOn;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "order_package")
	private Set<Tourpackage> tourpackage;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinTable(name = "order_user")
	private User users;

	/*
	 * @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	 * 
	 * @JoinTable(name = "order_price") private List<Price> price;
	 */

	private String totalPrice;

	/*
	 * public List<Price> getPrice() { return price; }
	 * 
	 * public void setPrice(List<Price> price) { this.price = price; }
	 */

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Set<Tourpackage> getTourpackage() {
		return tourpackage;
	}

	public void setTourpackage(Set<Tourpackage> tourpackage) {
		this.tourpackage = tourpackage;
	}

	public User getUsers() {
		return users;
	}

	public void setUsers(User users) {
		this.users = users;
	}

}
