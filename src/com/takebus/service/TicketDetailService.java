package com.takebus.service;

import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takebus.dao.TicketDetailDao;
import com.takebus.model.TicketDetail;

@Path("/ticketDetail")
public class TicketDetailService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<TicketDetail> getTicketDetails() {
		List<TicketDetail> list = new ArrayList<TicketDetail>();
		list.addAll(TicketDetailDao.instance.getModel().values());
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = TicketDetailDao.instance.getModel().size();
		return String.valueOf(count);
	}

}
