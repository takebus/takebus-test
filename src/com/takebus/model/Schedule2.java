package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Schedule2 {

	private String departureTime;
	private String arrivalTime;
	private String operator;
	private String schedualIDStr;
	private String price;
	private String departureStation;
	private String arrivalStation;
	private String duration;
	private String availability;
	
	public Schedule2(String departureTime, String arrivalTime, String operator,
					String schedualIDStr, String price, String departureStation,
					String arrivalStation, String duration, String availability) {
		super();
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.operator = operator;
		this.schedualIDStr = schedualIDStr;
		this.price = price;
		this.departureStation = departureStation;
		this.arrivalStation = arrivalStation;
		this.duration = duration;
		this.availability = availability;
	}
	
	public String getDepartureTime() {
		return departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public String getOperator() {
		return operator;
	}
	public String getSchedualIDStr() {
		return schedualIDStr;
	}
	public String getPrice() {
		return price;
	}
	public String getDepartureStation() {
		return departureStation;
	}
	public String getArrivalStation() {
		return arrivalStation;
	}
	public String getDuration() {
		return duration;
	}
	public String getAvailability() {
		return availability;
	}
}
