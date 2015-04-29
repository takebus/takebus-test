package com.takebus.service;

import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.takebus.dao.BusOperatorDao;
import com.takebus.dao.ScheduleDetailDao;
import com.takebus.model.ScheduleDetail;

@Path("/scheduleDetail")
public class ScheduleDetailService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ScheduleDetail> getScheduleDetails() {
		List<ScheduleDetail> list = new ArrayList<ScheduleDetail>();
		list.addAll(ScheduleDetailDao.instance.getModel().values());
		return list;
	}

	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = BusOperatorDao.instance.getModel().size();
		return String.valueOf(count);
	}
	
	@POST
	@Path("/search")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String getSchedule_InForm_OutJson(@FormParam("departure") String departure,
							  @FormParam("arrival") String arrival,
							  @FormParam("type") String type,
							  @FormParam("departureDate") String departureDate,
							  @FormParam("returnDate") String returnDate) {
		Gson gson = new Gson();
		
		List<ScheduleDetail> ld = new ArrayList<ScheduleDetail>();
		List<ScheduleDetail> lr = new ArrayList<ScheduleDetail>();
		ScheduleDetail sd1 = ScheduleDetailDao.instance.getModel().get("1");
		ScheduleDetail sd2 = ScheduleDetailDao.instance.getModel().get("2");
		ScheduleDetail sd3 = ScheduleDetailDao.instance.getModel().get("3");
		ScheduleDetail sd4 = ScheduleDetailDao.instance.getModel().get("4");
		ld.add(sd1);
		ld.add(sd2);
		ld.add(sd3);
		ld.add(sd4);
		
		ScheduleDetail sd5 = ScheduleDetailDao.instance.getModel().get("5");
		ScheduleDetail sd6 = ScheduleDetailDao.instance.getModel().get("6");
		ScheduleDetail sd7 = ScheduleDetailDao.instance.getModel().get("7");
		ScheduleDetail sd8 = ScheduleDetailDao.instance.getModel().get("8");
		ScheduleDetail sd9 = ScheduleDetailDao.instance.getModel().get("9");
		lr.add(sd5);
		lr.add(sd6);
		lr.add(sd7);
		lr.add(sd8);
		lr.add(sd9);
		
		Map<String, List<ScheduleDetail>> hmap = new HashMap<String, List<ScheduleDetail>>();
		hmap.put("departure", ld);
		hmap.put("return", lr);
		
		return gson.toJson(hmap);
	}
	
	private static boolean isNotNull(String txt) {
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}
	
}
