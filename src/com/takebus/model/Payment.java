package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Payment {
	
	private int paymentID;
	
	private float amount;
	
	private String firstName;
	private String lastName;
	private String type;
	private String cardNumber;
	private String sid;
	private String expire;
	
	private String shippingAddress;
	private String billingAddress;
	private String billingCity;
	private String billingState;
	private String billingZip;
	private String billingCountry;
	
	public Payment() {}
	
	public Payment(int paymentID, float amount, String firstName, String lastName, String type, String cardNumber, String sid, String expire,
					String shippingAddress, String billingAddress, String billingCity, String billingState, String billingZip, String billingCountry) {
		this.paymentID = paymentID;
		this.amount = amount;
		this.firstName = firstName;
		this.lastName = lastName;
		this.type = type;
		this.cardNumber = cardNumber;
		this.sid = sid;
		this.expire = expire;
		this.shippingAddress = shippingAddress;
		this.billingAddress = billingAddress;
		this.billingCity = billingCity;
		this.billingState = billingState;
		this.billingZip = billingZip;
		this.billingCountry = billingCountry;
	}
	
	
	public int getPaymentID() {return paymentID;}
	public void setPaymentID(int paymentID) {
		this.paymentID = paymentID;
	}	
	
	public float getAmount() { return amount;}
	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getFirstName() { return firstName;}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}	
	
	public String getLastName() { return lastName;}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getType() { return type;}
	public void setType(String type) {
		this.type = type;
	}
	
	public String getCardNumber() { return cardNumber;}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	
	public String getSid() { return sid;}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	public String getExpire() { return expire;}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	
	public String getShippingAddress() { return shippingAddress;}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	
	public String getBillingAddress() { return billingAddress;}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
	public String getBillingCity() { return billingCity;}
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}
	
	public String getBillingState() { return billingState;}
	public void setBillingState(String billingState) {
		this.billingState = billingState;
	}
	
	public String getBillingZip() { return billingZip;}
	public void setBillingZip(String billingZip) {
		this.billingZip = billingZip;
	}
	
	public String getBillingCountry() { return billingCountry;}
	public void setBillingCountry(String billingCountry) {
		this.billingCountry = billingCountry;
	}
	
	@Override
	public String toString() {
		return 	"paymentID:" + this.paymentID + ", " +
				"amount:" + this.amount + ", " + 
				"firstName:" + this.firstName + ", " +
				"lastName:" + this.lastName + ", " +
				"type:" + this.type + ", " + 
				"cardNumber:" + this.cardNumber + ", " + 
				"sid:" + this.sid + ", " +
				"expire:" + this.expire + ", " + 
				"shippingAddress:" + this.shippingAddress + ", " + 
				"billingAddress:" + this.billingAddress + ", " + 
				"billingCity:" + this.billingCity + ", " + 
				"billingState:" + this.billingState + ", " +
				"billingZip:" + this.billingZip + ", " +
				"billingCountry:" + this.billingCountry;
	}
}
