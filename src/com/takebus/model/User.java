package com.takebus.model;




import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;


@XmlRootElement
//@JsonIgnoreProperties( { "password" })
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonIgnoreProperties(value = { "password" })
@JsonIgnoreProperties(ignoreUnknown = true, value = { "password" }) 
public class User {

	private int userID;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String createdDate;
	private String lastModifiedDate;
	
	public User() {}
	
	public User(int userID, String email, String password, String firstName, String lastName, String phoneNumber, String address, 
			String city, String state, String zip, String country, String createdDate, String lastModifiedDate) {
		this.userID = userID;
		this.email = email;	
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
		this.createdDate = createdDate;
		this.lastModifiedDate = lastModifiedDate;
	}
	
	public int getUserID() {return userID;}
	public void setUserID(int userID) {
		this.userID = userID;
	}	

	public String getEmail() { return email;}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	public String getPassword() { return password;}
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

	public String getZip() { return zip;}
	public void setZip(String zip) {
		this.zip = zip;
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
		return 	"userID:" + this.userID + ", " +
				"email:" + this.email + ", " + 
				"password:" + this.password + ", " + 
				"firstName:" + this.firstName + ", " +
				"lastName:" + this.lastName + ", " +
				"phoneNumber:" + this.phoneNumber + ", " + 
				"address:" + this.address + ", " + 
				"city:" + this.city + ", " +
				"state:" + this.state + ", " +
				"zip:" + this.zip + ", " +
				"country:" + this.country + ", " +
				"createdDate:" + this.createdDate + ", " +
				"lastModifiedDate:" + this.lastModifiedDate;
	}
}
