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
    		return "yes";
    	}
    	else {
    		return "no";
    	}
    }     
}