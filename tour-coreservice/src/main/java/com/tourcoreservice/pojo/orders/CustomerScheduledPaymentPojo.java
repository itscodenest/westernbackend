package com.tourcoreservice.pojo.orders;

import com.tourcoreservice.entity.CustomerInvoice;

public class CustomerScheduledPaymentPojo {
	private long id;
	private CustomerInvoice invoiceid;
	private String paydiscriptin;
	private long amount;
	private String duedate;
	private long tax;
	
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
