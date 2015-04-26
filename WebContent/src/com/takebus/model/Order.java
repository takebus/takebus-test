package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Order {

	private int orderID;
	private int customerID;

	
	private String orderDate;
	//private float discount;
	
	private String purchased;
	
	public Order() {}
	
	public Order(int orderID, int customerID, String orderDate, String purchased) {
		this.orderID = orderID;
		this.customerID = customerID;
		this.orderDate = orderDate;
		this.purchased = purchased;
	}
	
	public int getOrderID() { return orderID;}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	
	public int getCustomerID() { return customerID;}
	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}
	
	public String getOrderDate() { return orderDate;}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public String getPurchased() { return purchased;}
	public void setPurchased(String purchased) {
		this.purchased = purchased;
	}	
}