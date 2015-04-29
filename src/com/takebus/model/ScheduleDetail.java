package com.takebus.model;

import java.util.*;

public class ScheduleDetail {
	private int scheduleID;
	private String scheduleIDStr;
	
	private String departureTime;
	private List<Station> departureStations;
	
	private String arrivalTime;
	private List<Station> arrivalStations;
	
	private BusOperator busOperator;
	private float price;
	private int availability;
	
	public ScheduleDetail() {}

	public ScheduleDetail(int scheduleID, String scheduleIDStr, String departureTime, List<Station> departureStations, 
			 String arrivalTime, List<Station> arrivalStations, BusOperator busOperator, float price,
			 int availability) {
		this.scheduleID = scheduleID;
		this.scheduleIDStr = scheduleIDStr;
		
		this.departureStations = departureStations;
		this.departureTime = departureTime;
		
		this.arrivalStations = arrivalStations;
		this.arrivalTime = arrivalTime;
		
		this.busOperator = busOperator;
		this.price = price;
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
	
	public List<Station> getDepartureStations() { return departureStations;}
	public void setDepartureStations(List<Station> departureStations) {
		this.departureStations = departureStations;
	}
	
	public String getDepartureTime() { return departureTime;}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public List<Station> getArrivalStations() { return arrivalStations;}
	public void setArrivalStations(List<Station> arrivalStations) {
		this.arrivalStations = arrivalStations;
	}
	
	public String getArrivalTime() { return arrivalTime;}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public BusOperator getBusOperator() { return busOperator;}
	public void setBusOperator(BusOperator busOperator) {
		this.busOperator = busOperator;
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