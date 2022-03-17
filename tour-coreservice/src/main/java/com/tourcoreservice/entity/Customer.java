package com.tourcoreservice.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@Entity
@DiscriminatorValue("CUSTOMER")  
public class Customer extends User {
	
private long customerId;
private String firstName;
private String lastName;
private String name;
private String photoUrl;
private String provider;
private String email;
private String idToken;
private String authToken;


public long getCustomerId() {
	return customerId;
}

public void setCustomerId(long customerId) {
	this.customerId = customerId;
}

public String getFirstName() {
	return firstName;
}

public void setFirstName(String firstName) {
	this.firstName = firstName;
}

public String getLastName() {
	return lastName;
}

public void setLastName(String lastName) {
	this.lastName = lastName;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getPhotoUrl() {
	return photoUrl;
}

public void setPhotoUrl(String photoUrl) {
	this.photoUrl = photoUrl;
}

public String getProvider() {
	return provider;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getIdToken() {
	return idToken;
}

public void setIdToken(String idToken) {
	this.idToken = idToken;
}

public String getAuthToken() {
	return authToken;
}

public void setAuthToken(String authToken) {
	this.authToken = authToken;
}

public void setProvider(String provider) {
	this.provider = provider;
}





	
}
