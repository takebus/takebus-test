package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Schedule {
	
	private int scheduleID;
	private String scheduleIDStr;
	private int departureCityID;
	private String departureTime;
	private int arrivalCityID;
	private String arrivalTime;
	private int busOperatorID;
	private float price;
	//private String duration;
	private int availability;
	
	public Schedule() {}
	
	public Schedule(int scheduleID, String scheduleIDStr, int departureCityID, String departureTime, 
				    int arrivalCityID, String arrivalTime, int busOperatorID, float price, 
				    int availability) {
		this.scheduleID = scheduleID;
		this.scheduleIDStr = scheduleIDStr;
		this.departureCityID = departureCityID;
		this.departureTime = departureTime;
		this.arrivalCityID = arrivalCityID;
		this.arrivalTime = arrivalTime;
		this.busOperatorID = busOperatorID;
		this.price = price;
		//this.duration = duration;
		this.availability = availability;
	}
	
	public int getScheduleID() { return scheduleID;}
	public void setScheduleID(int scheduleID) {
		this.scheduleID = scheduleID;
	}
	
	public String getScheduleIDStr() { return scheduleIDStr;}
	public void setScheduleIDStr(String scheduleIDStr) {
		this.scheduleIDStr = scheduleIDStr;
	}
	
	public int getDepartureCityID() { return departureCityID;}
	public void setDepartureCityID(int departureCityID) {
		this.departureCityID = departureCityID;
	}
	
	public String getDepartureTime() { return departureTime;}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public int getArrivalCityID() { return arrivalCityID;}
	public void setArrivalCityID(int arrivalCityID) {
		this.arrivalCityID = arrivalCityID;
	}
	
	public String getArrivalTime() { return arrivalTime;}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public int getBusOperatorID() { return busOperatorID;}
	public void setBusOperatorID(int busOperatorID) {
		this.busOperatorID = busOperatorID;
	}
	
	public float getPrice() { return price;}
	public void setPrice(float price) {
		this.price = price;
	}

	public int getAvailability() { return availability;}
	public void setAvailability(int availability) {
		this.availability = availability;
	}
}