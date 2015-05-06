package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Duration {

	private int departureStationID;
	private String departureTime;
	private int arrivalStationID;
	private String arrivalTime;

	private String durationTime;
	
	public Duration() {}

	public Duration(int departureStationID, String departureTime, int arrivalStationID, String arrivalTime, String durationTime) {
		this.departureStationID = departureStationID;
		this.departureTime = departureTime;
		this.arrivalStationID = arrivalStationID;
		this.arrivalTime = arrivalTime;
		this.durationTime = durationTime;
	}
	
	public int getDepartureStationID() {
		return departureStationID;
	}

	public void setDepartureStationID(int departureStationID) {
		this.departureStationID = departureStationID;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalStationID() {
		return arrivalStationID;
	}

	public void setArrivalStationID(int arrivalStationID) {
		this.arrivalStationID = arrivalStationID;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDurationTime() {
		return durationTime;
	}

	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	
	
}
