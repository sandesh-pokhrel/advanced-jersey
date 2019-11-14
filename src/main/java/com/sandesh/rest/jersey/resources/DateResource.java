package com.sandesh.rest.jersey.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sandesh.rest.jersey.models.MyDate;

@Path("/date/{myDate}")
@Produces(MediaType.TEXT_PLAIN)
public class DateResource {

	@GET
	public String getRequestedDate(@PathParam("myDate") MyDate myDate) {
		return "Passed dateString is: " + myDate.toString();
	}
}
