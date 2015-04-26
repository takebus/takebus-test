package com.takebus.service;

import java.io.IOException;

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

import com.takebus.model.Student;


@Path("/student")
public class StudentService {

	@GET
	@Path("/print/{name}")
	@Produces(MediaType.APPLICATION_JSON)
	public Student produceJSON( @PathParam("name") String name ) {

		Student st = new Student(name, "Diaz",22,1);

		return st;

	}
/*	
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response consumeJSON( Student student ) {

		String output = student.toString();

		return Response.status(200).entity(output).build();
	}
*/
	
    @POST
    @Path("/data/{param}")
    public Response postMsg(@PathParam("param") String msg) {
        String output = "POST:Jersey say : " + msg;
        return Response.status(200).entity(output).build();
    }
   
    @POST
    @Produces(MediaType.TEXT_HTML)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String newTodo(@FormParam("id") int id,
        @FormParam("firstName") String firstName,
        @FormParam("lastName") String lastName,
        @FormParam("age") int age,
        @Context HttpServletResponse servletResponse) throws IOException {

    	System.out.println(id + ", " + firstName + ", " + lastName + ", " + age);
    	return "success";
    }   
 /*   
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Student consumeJSON( Student student ) {

		String output = student.toString();
		System.out.println(output);
		//return "success";
		return student;
	}
*/	
    
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String consumeJSON( Student student ) {
	
		System.out.println(student.toString());
		return "success";
	}

	
}
