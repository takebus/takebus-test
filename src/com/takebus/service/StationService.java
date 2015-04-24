package com.takebus.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.takebus.dao.StationDao;
import com.takebus.model.Station;

import java.util.*;

@Path("/station")
public class StationService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Station> getStations() {
		List<Station> list = new ArrayList<Station>();
		list.addAll(StationDao.instance.getModel().values());
		
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = StationDao.instance.getModel().size();
	
		return String.valueOf(count);
	}

}
