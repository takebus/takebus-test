package com.takebus.service;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takebus.dao.BusOperatorDao;
import com.takebus.model.BusOperator;


@Path("/busOperator")
public class BusOperatorService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<BusOperator> getPayments() {
		List<BusOperator> list = new ArrayList<BusOperator>();
		list.addAll(BusOperatorDao.instance.getModel().values());
		
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = BusOperatorDao.instance.getModel().size();
		return String.valueOf(count);
	}
}
