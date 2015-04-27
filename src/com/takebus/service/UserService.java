package com.takebus.service;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
    public String loginCheck(@FormParam("email") String email,
    							@FormParam("password") String password) throws IOException {
    	
    	System.out.println(email + ", " + password);
    	System.out.println(UserDao.instance.getModel().containsKey(email));
    	
		Gson gson = new Gson();
		Map<String, User> hmap = new HashMap<String, User>();
		
    	if (UserDao.instance.getModel().containsKey(email) &&
    			UserDao.instance.getModel().get(email).getPassword().equals(password)) {
    		//return "success";
    		hmap.put("user", UserDao.instance.getModel().get(email));
    	}
    	else {
    		//return "failed";
    		hmap.put("user", null);
    	}
    	return gson.toJson(hmap);
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
			@FormParam("country") String country) throws IOException {
		
		System.out.println(
				"email:" + email + ", " + 
				"password:" + password + ", " + 
				"firstName:" + firstName + ", " +
				"lastName:" + lastName + ", " +
				"phoneNumber:" + phoneNumber + ", " + 
				"address:" + address + ", " + 
				"city:" + city + ", " +
				"state:" + state + ", " +
				"zip:" + zip + ", " +
				"country:" + country);
		
		Gson gson = new Gson();
		Map<String, String> succ = new HashMap<String, String>();
		succ.put("callback", "success");
		Map<String, String> fail = new HashMap<String, String>();
		fail.put("callback", "failed");
		
		if ( !UserDao.instance.getModel().containsKey(email) ) return gson.toJson(fail);
		User ux = UserDao.instance.getModel().get(email);
		
		if (email != "") ux.setEmail(email);;
		if (password != "") ux.setPassword(password);;
		if (firstName != "") ux.setFirstName(firstName);;	
		if (lastName != "") ux.setLastName(lastName);;
		if (phoneNumber != "") ux.setPhoneNumber(phoneNumber);
		if (address != "") ux.setAddress(address);
		if (city != "") ux.setCity(city);
		if (state != "") ux.setState(state);
		if (zip != "") ux.setZip(zip);
		if (country != "") ux.setcountry(country);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		String lastModifiedDate = dateFormat.format(date);
		ux.setLastModifiedDate(lastModifiedDate);
		return gson.toJson(succ);
	}  	
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public String register_inForm_outText(@FormParam("email") String email, 
			@FormParam("password") String password, 
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("phoneNumber") String phoneNumber,
			@FormParam("address") String address,
			@FormParam("city") String city,
			@FormParam("state") String state,
			@FormParam("zip") String zip,
			@FormParam("country") String country) throws IOException {
		
		if ( UserDao.instance.getModel().containsKey(email) ) return "registered";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		
		String createdDate = dateFormat.format(date);
		int uid = UserDao.instance.getModel().size() + 1;
		
		User user = new User(uid, email, password, firstName, lastName, phoneNumber, address, city, state, zip, country, createdDate, "");
		UserDao.instance.getModel().put(email, user);
		
		System.out.println(user.toString());
		return "success";
	} 	

	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	public String register_inJson_outText(User user) throws IOException {
		
		if ( UserDao.instance.getModel().containsKey(user.getEmail()) ) return "registered";
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2014/08/06 15:59:48
		
		String createdDate = dateFormat.format(date);
		int uid = UserDao.instance.getModel().size() + 1;
		String email = user.getEmail();
		
		user.setUserID(uid);
		user.setCreatedDate(createdDate);
		
		UserDao.instance.getModel().put(email, user);
		
		System.out.println(user.toString());
		return "success";
	} 
}
