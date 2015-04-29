package com.takebus.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takebus.dao.ScheduleDao;
import com.takebus.model.Schedule;

@Path("/schedule")
public class ScheduleService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Schedule> getSchedules() {
		List<Schedule> list = new ArrayList<Schedule>();
		list.addAll(ScheduleDao.instance.getModel().values());
		
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = ScheduleDao.instance.getModel().size();
		return String.valueOf(count);
	}
}