package com.takebus.model;

public class TicketDetail {
	private int ticketID;
	//private int userID;
	private User user;
	//private int orderID;
	private Order order;
	
	private String scheduleIDStr;
	
	private String departureStation;
	private String departureCity;
	private String departureTime;
	
	private String arrivalStation;
	private String arrivalCity;
	private String arrivalTime;
	
	private String busOperator;
	
	private String ticketDate;

	private String ticketType;
	private String barcode;
	private String expire;	
	
	private float price;
	String holderName;
	
	public TicketDetail() {}
	public TicketDetail(int ticketID, User user, Order order, String scheduleIDStr, String departureStation, String departureCity, String departureTime, 
			String arrivalStation, String arrivalCity, String arrivalTime, String busOperator, String ticketDate, String ticketType, String barcode, 
			String expire, float price, String holderName) {
		this.ticketID = ticketID;
		this.user = user;
		this.order = order;
		this.scheduleIDStr = scheduleIDStr;
		this.departureStation = departureStation;
		this.departureCity = departureCity;
		this.departureTime = departureTime;
		this.arrivalStation = arrivalStation;
		this.arrivalCity = arrivalCity;
		this.arrivalTime = arrivalTime;
		this.busOperator = busOperator;
		this.ticketDate = ticketDate;
		this.ticketType = ticketType;
		this.barcode = barcode;
		this.expire = expire;
		this.price = price;
		this.holderName = holderName;
	}
	
	public int getTicketID() { return ticketID;}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
	public User getUser() { return user;}
	public void setUser(User user) {
		this.user = user;
	}
	
	public Order getOrder() { return order;}
	public void setOrder(Order order) {
		this.order = order;
	}
		
	public String getScheduleIDStr() { return scheduleIDStr;}
	public void setScheduleIDStr(String scheduleIDStr) {
		this.scheduleIDStr = scheduleIDStr;
	}
	
	public String getDepartureStation() { return departureStation;}
	public void setDepartureStation(String departureStation) {
		this.departureStation = departureStation;
	}
	
	public String getDepartureCity() { return departureCity;}
	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}
	
	public String getDepartureTime() { return departureTime;}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	
	public String getArrivalStation() { return arrivalStation;}
	public void setArrivalStation(String arrivalStation) {
		this.arrivalStation = arrivalStation;
	}
	
	public String getArrivalCity() { return arrivalCity;}
	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}
	
	public String getArrivalTime() { return arrivalTime;}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	
	public String getBusOperator() { return busOperator;}
	public void setBusOperator(String busOperator) {
		this.busOperator = busOperator;
	}
	
	public String getTicketDate() { return ticketDate;}
	public void setTicketDate(String ticketDate) {
		this.ticketDate = ticketDate;
	}
	
	public String getTicketType() { return ticketType;}
	public void setTicketType(String ticketType) {
		this.ticketType = ticketType;
	}
	
	public String getBarcode() { return barcode;}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	public String getExpire() { return expire;}
	public void setExpire(String expire) {
		this.expire = expire;
	}
	
	public float getPrice() { return price;}
	public void setPrice(float price) {
		this.price = price;
	}
	
	public String getHolderName() { return holderName;}
	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}
}
