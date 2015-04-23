package com.takebus.service;

import java.io.IOException;
import java.util.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.takebus.dao.UserDao;
import com.takebus.model.User;



@Path("/user")
public class UserService {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	public List<User> getCustomers() {
		List<User> users = new ArrayList<User>();
		users.addAll(UserDao.instance.getModel().values());
		return users;
	}
	
	@GET
	@Path("count")
	@Produces(MediaType.TEXT_PLAIN)
	public String getCount() {
		int count = UserDao.instance.getModel().size();
		return String.valueOf(count);
	}
	
	@GET
	@Path("/{email}")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<User> getUserByEmail(@PathParam("email") String email) {
		User x = UserDao.instance.getModel().get(email);
		List<User> list = new ArrayList<User>();
		list.add(x);
		return list;
	}
	
    @POST
	@Path("/login")
    //@Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String loginCheck(@FormParam("email") String email,
    							@FormParam("password") String password) throws IOException {
    	String out = email + ", " + password;
    	System.out.println(out);
    	System.out.println(UserDao.instance.getModel().containsKey(email));
    	//System.out.println(UserDao.instance.getModel().get(email));
    	if (UserDao.instance.getModel().containsKey(email) &&
    			UserDao.instance.getModel().get(email).getPassword().equals(password)) {
    		return "success";
    	}
    	else {
    		return "failed";
    	}
    }    
     
    
    @POST
	@Path("/update")
    @Consumes(MediaType.APPLICATION_JSON)
    public String update_inJson_outText(User user) throws IOException {
    	System.out.println(user.toString());
    	
    	if (UserDao.instance.getModel().containsKey(user.getEmail())) {
    		User ux = UserDao.instance.getModel().get(user.getEmail());
    		
    		if (user.getPassword() != "") ux.setPassword(user.getPassword());
    		if (user.getFirstName() != "") ux.setFirstName(user.getFirstName());
    		if (user.getLastName() != "") ux.setLastName(user.getLastName());
    		
    		return "success";
    	}
    	else {
    		return "failed";
    	}
    }
    
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String update_inJson_outJson(User user) throws IOException {
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Gson gson = new Gson();
		
		return gson.toJson(succ);
	}   
	
	@POST
	@Path("/update")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String update_inForm_outJson(@FormParam("email") String email, 
			@FormParam("password") String password, 
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("phoneNumber") String phoneNumber,
			@FormParam("address") String address,
			@FormParam("city") String city,
			@FormParam("state") String state,
			@FormParam("zip") String zip,
			@FormParam("country") String country,
			@FormParam("lastModifiedDate") String lastModifiedDate) throws IOException {
		
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Gson gson = new Gson();
		
		return gson.toJson(succ);
	}  	
}
