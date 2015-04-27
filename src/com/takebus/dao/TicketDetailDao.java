package com.takebus.dao;

import java.util.*;

import com.takebus.model.Order;
import com.takebus.model.TicketDetail;
import com.takebus.model.User;

public enum TicketDetailDao {

	instance;
	
	private Map<String, TicketDetail> ticketDetailPool = new HashMap<String, TicketDetail>();
	
	private TicketDetailDao() {
		
		User u1 = UserDao.instance.getModel().get("dean@gmail.com");
		
		Order o1 = OrderDao.instance.getModel().get("1");
		Order o2 = OrderDao.instance.getModel().get("2");
		
		TicketDetail t1 = new TicketDetail(1, u1, o1, "CBT583", "1400 Washington Ave", "7:20am", "888 6th Ave", "11:00am", "Capital Bus Tours", "2015-04-21", "round", "barcode", "yes", 15);
		TicketDetail t2 = new TicketDetail(2, u1, o1, "CBT134", "888 6th Ave", "8:30am", "1400 Washington Ave", "12:00pm", "Capital Bus Tours", "2015-04-22", "round", "barcode", "yes", 15);
		
		TicketDetail t3 = new TicketDetail(3, u1, o2, "CBT783", "1400 Washington Ave", "5:50pm", "888 6th Ave", "9:30pm", "Capital Bus Tours", "2015-05-12", "single", "barcode", "no", 15);

		ticketDetailPool.put("1", t1);
		ticketDetailPool.put("2", t2);
		ticketDetailPool.put("3", t3);
	}
	
	public Map<String, TicketDetail> getModel() {
		return ticketDetailPool;
	}
}
