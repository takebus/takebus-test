package com.takebus.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.takebus.model.User;



@Path("/user")
public class UserService {

	private HashMap<String, List<User>> hmap;
	private List<User> cus;
	
	public UserService() {
		User c1 = new User(1, "dean@gmail.com", "123456", "Dean", "Brian", "4051237890", "123 Ame Ave", "Milpita", "CA", "95123", "US", "2015-04-12", "2015-04-12");
		User c2 = new User(2, "richard@gmail.com", "123456", "Richard", "Claderman", "5041237890", "N 1st St", "SF", "CA", "95012", "US", "2015-04-12", "2015-04-12");
		User c3 = new User(3, "allian@gmail.com", "123456", "Allian", "Abthtoms", "4051237890", "E 12th St", "San Jose", "CA", "95112", "US", "2015-04-12", "2015-04-12");
	
		cus = new LinkedList<User>();
		cus.add(c1);
		cus.add(c2);
		cus.add(c3);
		
		hmap = new HashMap<String, List<User>>();
		List<User> l1 = new LinkedList<User>();
		l1.add(c1);
		List<User> l2 = new LinkedList<User>();
		l2.add(c2);
		List<User> l3 = new LinkedList<User>();
		l3.add(c3);
		hmap.put("dean@mail.com", l1);
		hmap.put("richard@gmail.com", l2);
		hmap.put("allian@gmail.com", l3);
	}

	@GET
	@Path("/xml")
	@Produces (MediaType.APPLICATION_XML)
	public List<User> getCustomersXML() {
		if (cus.size() > 0) {
			return cus;
		}
		else return null;
	}	
	
	@GET
	@Path("/json")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<User> getCustomersJson() {
		if (cus.size() > 0) {
			return cus;
		}
		else return null;
	}	

	@GET
	@Path("/xml/{name}")
	@Produces (MediaType.APPLICATION_XML)
	public List<User> getCustomerByNameXML(@PathParam("name") String name) {
		if(hmap.containsKey(name)) {
			
			return hmap.get(name);
		}
		else return null;
	}	
	
	@GET
	@Path("/json/{name}")
	@Produces(MediaType.APPLICATION_JSON)	
	public List<User> getCustomerByNameJson(@PathParam("name") String name) {
		if(hmap.containsKey(name)) {
			
			return hmap.get(name);
		}
		else return null;
	}

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON( User user ) {

		String output = user.toString();
		//output = "success";
		return Response.status(200).entity(output).build();
	}
	
    @POST
	@Path("/login")
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String loginCheck(
        @FormParam("email") String email,
        @FormParam("password") String password,
        @Context HttpServletResponse servletResponse) throws IOException {
    	
    	String out = email + ", " + password;
    	System.out.println(out);
    	return "success";
    }   
}