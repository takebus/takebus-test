package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Station {
	
	private int stationID;
	private String station;
	//private int cityID;
	private String city;
	private String state;
	
	public Station() {}
	
	public Station(int stationID, String station, String city, String state) {
		this.stationID = stationID;
		this.station = station;
		//this.cityID = cityID;
		this.city = city;
		this.state = state;
	}
	
	public int getStationID() { return stationID;}
	public void setStationID(int stationID) {
		this.stationID = stationID;
	} 
	
	public String getStation() { return station;}
	public void setStation(String station) {
		this.station = station;
	}

	public String getcity() { return city;}
	public void setcity(String city) {
		this.city = city;
	}
	
	public String getState() { return state;}
	public void setState(String state) {
		this.state = state;
	}
}