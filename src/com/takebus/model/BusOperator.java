package com.takebus.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BusOperator {
	
	private int busOperatorID;
	private String busOperatorName;
	
	public BusOperator() {}
	
	public BusOperator(int busOperatorID, String busOperatorName) {
		this.busOperatorID = busOperatorID;
		this.busOperatorName = busOperatorName;
	}
	
	public int getBusOperatorID() { return busOperatorID;}
	public void setBusOperatorID(int busOperatorID) {
		this.busOperatorID = busOperatorID;
	}
	
	public String getBusOperatorName() { return busOperatorName;}
	public void setBusOperatorName(String busOperator) {
		this.busOperatorName = busOperatorName;
	}
}