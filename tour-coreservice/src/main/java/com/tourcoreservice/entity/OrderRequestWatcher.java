package com.tourcoreservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class OrderRequestWatcher {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
