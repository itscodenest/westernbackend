package com.tourcoreservice.pojo.orders;

public class ApproverHirarchyPojo {

	private long id;

	private long orderId;

	private long status;

	private long orderType;

	private long substituterId;

	private long createrId;

	private long approverId;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getOrderType() {
		return orderType;
	}

	public void setOrderType(long orderType) {
		this.orderType = orderType;
	}

	public long getSubstituterId() {
		return substituterId;
	}

	public void setSubstituterId(long substituterId) {
		this.substituterId = substituterId;
	}

	public long getCreaterId() {
		return createrId;
	}

	public void setCreaterId(long createrId) {
		this.createrId = createrId;
	}

	public long getApproverId() {
		return approverId;
	}

	public void setApproverId(long approverId) {
		this.approverId = approverId;
	}
	

}
