package com.takebus.model;


import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

//@XmlRootElement
//@JsonIgnoreProperties( { "password" })
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties(value = { "password" })
@JsonIgnoreProperties(ignoreUnknown = true, value = { "password" }) 
public class User {

	private int customerID;
	private String email;
	@JsonIgnore 
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String zipCode;
	private String country;
	private String createdDate;
	private String lastModifiedDate;
	
	public User() {}
	
	public User(int customerID, String email, String password, String firstName, String lastName, String phoneNumber, String address, 
			String city, String state, String zipCode, String country, String createdDate, String lastModifiedDate) {
		this.customerID = customerID;
		this.email = email;	
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.country = country;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public int getCustomerID() {return customerID;}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}	

	public String getEmail() { return email;}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	@JsonIgnore
	public String getPassword() { return password;}
	@JsonIgnore
	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() { return firstName;}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() { return lastName;}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getPhoneNumber() { return phoneNumber;}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}	
	
	public String getAddress() { return address;}
	public void setAddress(String address) {
		this.address = address;
	}		

	public String getCity() { return city;}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() { return state;}
	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() { return zipCode;}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	
	public String getcountry() { return country;}
	public void setcountry(String country) {
		this.country = country;
	}
	
	public String getCreatedDate() { return createdDate;}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	
	public String getLastModifiedDate() { return lastModifiedDate;}
	public void setLastModifiedDate(String lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}
	
	@Override
	public String toString() {
		return this.email + ", " + this.firstName + ", " + this.lastName;
	}
}
