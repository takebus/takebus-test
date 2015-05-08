package com.takebus.dao;

import java.util.*;

import com.takebus.model.Ticket;

public enum TicketDao {
	instance;
	
	private Map<String, Ticket> ticketPool = new HashMap<String, Ticket>();
	
	private TicketDao() {
		Ticket t1 = new Ticket(1, 1, 1, "CBT583", "1400 Washington Ave", "7:20am", "888 6th Ave", "11:00am", "Capital Bus Tours", "2015-04-21", "round", "barcode", "yes", 15, "Dean Brian");
		Ticket t2 = new Ticket(2, 1, 1, "CBT134", "888 6th Ave", "8:30am", "1400 Washington Ave", "12:00pm", "Capital Bus Tours", "2015-04-22", "round", "barcode", "yes", 15, "Dean Brian");
		
		Ticket t3 = new Ticket(3, 1, 2, "CBT783", "1400 Washington Ave", "5:50pm", "888 6th Ave", "9:30pm", "Capital Bus Tours", "2015-05-12", "single", "barcode", "no", 15, "Dean Brian");

		
		
		ticketPool.put("1", t1);
		ticketPool.put("2", t2);
		ticketPool.put("3", t3);
	}
	
	public Map<String, Ticket> getModel() {
		return ticketPool;
	}
}
