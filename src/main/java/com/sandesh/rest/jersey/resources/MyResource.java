package com.sandesh.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/resource")
@Produces(MediaType.TEXT_PLAIN)
//@Singleton   // Can be also achieved using static variable concept
public class MyResource {
	
	private int count;
	@QueryParam("username") private String username;  // This will not work if the resource is singleton as the instance will be already created before injection

	@GET
	public String testResource() {
		return "The count is: " + ++count + ", and username is: " + username;
	}
}
