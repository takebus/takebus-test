package com.takebus.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takebus.dao.TicketDao;
import com.takebus.model.Ticket;

import java.util.*;

@Path("/ticket")
public class TicketService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ticket> getTickets() {
		List<Ticket> list = new ArrayList<Ticket>();
		list.addAll(TicketDao.instance.getModel().values());
		
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		
		int count = TicketDao.instance.getModel().size();
		return String.valueOf(count);
	}
}
