package com.takebus.dao;

import java.util.*;

import com.takebus.model.Ticket;

public enum TicketDao {

	instance;
	
	private Map<String, Ticket> ticketPool = new HashMap<String, Ticket>();
	
	private TicketDao() {
		Ticket t1 = new Ticket(1, 1, 1, 1, "2015-04-21", "roundtrip", "barcode", "yes", 15);
		Ticket t2 = new Ticket(2, 1, 1, 5, "2015-04-22", "roundtrip", "barcode", "yes", 15);
		Ticket t3 = new Ticket(3, 1, 1, 1, "2015-05-20", "roundtrip", "barcode", "yes", 15);
		
		//Ticket t2 = new Ticket(2, 1, "Dean Brian", "2015-04-26", "", "", 15);
		
		//Ticket t3 = new Ticket(3, 3, "Richard Claderman", "2015-05-01", "", "", 15); 
		//Ticket t4 = new Ticket(4, 7, "Claderman Claderman", "2015-05-02", "", "", 15); 
		
		ticketPool.put("1", t1);
		ticketPool.put("2", t2);
		ticketPool.put("3", t3);
	}
	
	public Map<String, Ticket> getModel() {
		return ticketPool;
	}
}
