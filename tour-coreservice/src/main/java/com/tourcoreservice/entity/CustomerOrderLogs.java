package com.tourcoreservice.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class CustomerOrderLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String Messaged_by;
	private String Messaged_To;
	private String Message;

	public long order_id;
	private boolean Status;
	@CreationTimestamp
	private Date createdAt;
	@UpdateTimestamp
	private Date updated;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessaged_by() {
		return Messaged_by;
	}
	public void setMessaged_by(String messaged_by) {
		Messaged_by = messaged_by;
	}
	public String getMessaged_To() {
		return Messaged_To;
	}
	public void setMessaged_To(String messaged_To) {
		Messaged_To = messaged_To;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	public long getOrder_id() {
		return order_id;
	}
	public void setOrder_id(long order_id) {
		this.order_id = order_id;
	}
	public boolean isStatus() {
		return Status;
	}
	public void setStatus(boolean status) {
		Status = status;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
}
