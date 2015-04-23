package com.takebus.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.takebus.dao.PaymentDao;
import com.takebus.model.Payment;

import java.io.IOException;
import java.util.*;

@Path("/payment")
public class PaymentService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<Payment> getPayments() {
		List<Payment> list = new ArrayList<Payment>();
		list.addAll(PaymentDao.instance.getModel().values());
		
		return list;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count =  PaymentDao.instance.getModel().size();
		return String.valueOf(count);
	}
	
    @POST
	@Path("/pay")
    @Consumes(MediaType.APPLICATION_JSON)
    public String pay(Payment payinfo) throws IOException {
    	
    	System.out.println("payment info: " + payinfo.toString());
    	
    	return "yes";
    }
}
