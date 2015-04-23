package com.takebus.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
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
    public String pay_inJson_outText(Payment payinfo) throws IOException {
    	
    	System.out.println("inJson_outText: " + payinfo.toString());
    	
    	return "success";
    }
    
    @POST
	@Path("/pay")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public String pay_inJson_outJson(Payment payinfo) throws IOException {
    	
    	System.out.println("inJson_outJson: " + payinfo.toString());
    	
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Gson gson = new Gson();
		
		return gson.toJson(succ);
    }
    
    @POST
	@Path("/pay")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String pay_inForm_outText(@FormParam("amount") float amount, 
			@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName,
			@FormParam("type") String type,
			@FormParam("cardNumber") String cardNumber,
			@FormParam("sid") String sid,
			@FormParam("expire") String expire,
			@FormParam("shippingAddress") String shippingAddress,
			@FormParam("billingAddress") String billingAddress,
			@FormParam("billingCity") String billingCity,
			@FormParam("billingState") String billingState,
			@FormParam("billingZip") String billingZip,
			@FormParam("billingCountry") String billingCountry) throws IOException {
    	
    	System.out.println("inFrom_outText:" + amount + "," + firstName + "," + lastName);
		
		return "success";
    }

    @POST
	@Path("/pay")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public String pay_inForm_outJson(@FormParam("amount") float amount, 
			@FormParam("firstName") String firstName, 
			@FormParam("lastName") String lastName,
			@FormParam("type") String type,
			@FormParam("cardNumber") String cardNumber,
			@FormParam("sid") String sid,
			@FormParam("expire") String expire,
			@FormParam("shippingAddress") String shippingAddress,
			@FormParam("billingAddress") String billingAddress,
			@FormParam("billingCity") String billingCity,
			@FormParam("billingState") String billingState,
			@FormParam("billingZip") String billingZip,
			@FormParam("billingCountry") String billingCountry) throws IOException {
    	
    	System.out.println("inFrom_outJson:" + amount + "," + firstName + "," + lastName);
    	
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Gson gson = new Gson();
		
		return gson.toJson(succ);
    }   
}
