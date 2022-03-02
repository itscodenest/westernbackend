package com.tourcoreservice.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CustomerscheduledPaymets {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
	@JoinColumn(name = "Invoice_id")
	private CustomerInvoice invoiceid;
	
	private String paydiscriptin;
	private long amount;
	private long tax;
	private String duedate;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public CustomerInvoice getInvoiceid() {
		return invoiceid;
	}
	public void setInvoiceid(CustomerInvoice invoiceid) {
		this.invoiceid = invoiceid;
	}
	public String getPaydiscriptin() {
		return paydiscriptin;
	}
	public void setPaydiscriptin(String paydiscriptin) {
		this.paydiscriptin = paydiscriptin;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public long getTax() {
		return tax;
	}
	public void setTax(long tax) {
		this.tax = tax;
	}
	public String getDuedate() {
		return duedate;
	}
	public void setDuedate(String duedate) {
		this.duedate = duedate;
	}
	
	
	
}
