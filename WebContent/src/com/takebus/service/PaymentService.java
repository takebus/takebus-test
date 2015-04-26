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
    public String pay_inJson_outText(Payment payment) throws IOException {
    	
    	int pid = PaymentDao.instance.getModel().size() + 1;
    	payment.setPaymentID(pid);
      	System.out.println("inForm_outJson:" + payment.toString());
    	
    	PaymentDao.instance.getModel().put(String.valueOf(pid), payment);
    	
    	return "success";
    }
    
    @POST
	@Path("/pay")
    @Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
    public String pay_inJson_outJson(Payment payment) throws IOException {
    	
    	int pid = PaymentDao.instance.getModel().size() + 1;
    	payment.setPaymentID(pid);
    	System.out.println("inForm_outJson:" + payment.toString());
    	
    	PaymentDao.instance.getModel().put(String.valueOf(pid), payment);
    	
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
    	
    	int pid = PaymentDao.instance.getModel().size() + 1;
    	Payment payment = new Payment(pid, amount, firstName, lastName, type, cardNumber, sid, expire, shippingAddress, billingAddress, billingCity, billingState, billingZip, billingCountry);
    	System.out.println("inForm_outJson:" + payment.toString());
    	
    	PaymentDao.instance.getModel().put(String.valueOf(pid), payment);
		
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
    	
    	int pid = PaymentDao.instance.getModel().size() + 1;
    	Payment payment = new Payment(pid, amount, firstName, lastName, type, cardNumber, sid, expire, shippingAddress, billingAddress, billingCity, billingState, billingZip, billingCountry);
    	System.out.println("inForm_outJson:" + payment.toString());
    	
    	PaymentDao.instance.getModel().put(String.valueOf(pid), payment);
    	
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Gson gson = new Gson();
		
		return gson.toJson(succ);
    }   
}
