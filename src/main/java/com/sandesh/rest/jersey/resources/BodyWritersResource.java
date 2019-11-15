package com.sandesh.rest.jersey.resources;

import java.util.Calendar;
import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/date-writer")
@Produces(MediaType.TEXT_PLAIN)
public class BodyWritersResource {

	@GET
	public Date writeDate() {
		return Calendar.getInstance().getTime();
	}
	
	@GET
	@Produces("text/shortdate") // Custom media type implemented (CustomMediaTypeMsgBodyWrtr is responsible for this..)
	public Date writeDateCustomMediaType() {
		return Calendar.getInstance().getTime();
	}
}
