package com.takebus.dao;

import java.util.*;

import com.takebus.model.Ticket;

public enum TicketDao {

	instance;
	
	private Map<String, Ticket> ticketPool = new HashMap<String, Ticket>();
	
	private TicketDao() {
		//Ticket t1 = new Ticket(1, 1, "Dean Brian", "2015-04-25", "", "", 15);
		//Ticket t2 = new Ticket(2, 5, "Dean Brian", "2015-04-26", "", "", 15);
		
		//Ticket t3 = new Ticket(3, 3, "Richard Claderman", "2015-05-01", "", "", 15); 
		//Ticket t4 = new Ticket(4, 7, "Claderman Claderman", "2015-05-02", "", "", 15); 
	}
	
	public Map<String, Ticket> getModel() {
		return ticketPool;
	}
}
