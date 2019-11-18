package com.sandesh.rest.jersey.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.sandesh.rest.jersey.models.ErrorMessage;

@Provider
public class InvalidSessionExceptionMapper implements ExceptionMapper<InvalidSessionException> {

	@Override
	public Response toResponse(InvalidSessionException exception) {
		return Response.status(Status.BAD_GATEWAY).entity(new ErrorMessage("Invalid Session", 401, "http://localhost:8080/advanced-jersey/webapi/resource"))
				.build();
	}

}
